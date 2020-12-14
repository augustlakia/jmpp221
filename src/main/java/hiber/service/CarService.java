package hiber.service;

import hiber.model.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    void add(Car user);
    List<Car> listUsers();
}
