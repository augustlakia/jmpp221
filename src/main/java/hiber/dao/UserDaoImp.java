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

        TypedQuery<User> hql = sessionFactory.getCurrentSession().createQuery("select user from User user where user.car.model=:name and user.car.series=:series", User.class)
                .setParameter("name", name).setParameter("series", series);

        return hql.getSingleResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

}
