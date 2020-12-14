package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public User find(Long id) {
      return sessionFactory.getCurrentSession().get(User.class, id);
   }

   @Override
   public User findByCar(String name, int series) {
      User foundUser = null;

      TypedQuery<Car> hql = sessionFactory.getCurrentSession().createQuery("from Car where model = :name and series = :ser", Car.class)
              .setParameter("name", name).setParameter("ser", series);
      Car car = hql.getSingleResult();

      List<User> listofAll = listUsers();

      for (User i: listofAll) {
         if(i.getCar().getId().equals(car.getId())) {
            foundUser = i;
         }
      }
      return foundUser;
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

}
