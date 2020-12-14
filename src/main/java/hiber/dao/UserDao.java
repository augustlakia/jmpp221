package hiber.dao;

import hiber.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
   void add(User user);
   User find(Long id);
   User findByCar(String name, int series);
   List<User> listUsers();

}
