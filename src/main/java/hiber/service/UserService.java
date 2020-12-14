package hiber.service;

import hiber.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void add(User user);
    User find(Long id);
    User findByCar(String name, int series);
    List<User> listUsers();
}
