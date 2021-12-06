package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car = new Car("Toyota", 2020);
      Car car1 = new Car("Lada", 2021);
      Car car2 = new Car("Skoda", 2018);
      Car car3 = new Car("Mercedes", 2000);

      User user = new User("User1", "Lastname1", "user1@mail.ru");
      User user1 = new User("User2", "Lastname2", "user2@mail.ru");
      User user2 = new User("User3", "Lastname3", "user3@mail.ru");
      User user3 = new User("User4", "Lastname4", "user4@mail.ru");

      user.setCar(car);
      car.setUser(user);
      car1.setUser(user1);
      user1.setCar(car1);
      car2.setUser(user2);
      user2.setCar(car2);
      car3.setUser(user3);
      user3.setCar(car3);


      userService.add(user);
      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      System.out.print(userService.getUserByCar("Mercedes", 2000).toString());
      context.close();
   }
}
