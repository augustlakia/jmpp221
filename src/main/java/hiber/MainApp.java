package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);
//      userService.add(new User("Alexey", "Navalny", "ciafbi@gosdep.ru", new Car("BMWX7", 2018)));
//      userService.add(new User("Adolf", "Hitler", "num1@thirdreich.de", new Car("Volkswagen", 1488)));
//      userService.add(new User("Kanye", "West", "yeezy@us.com", new Car("Lamborghini", 4242)));


      User Found1 = userService.findByCar("Volkswagen", 1488);
      System.out.println(Found1.getFirstName() + " " + Found1.getLastName());



      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      context.close();
   }
}
