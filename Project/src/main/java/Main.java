import config.ConnectionManager;
import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        UserService userService = UserServiceImpl.getInstance();

        User user = new User();
        user.setFirstName("Гладун");
        user.setLastName("Олег");
        user.setEmail("oleg@gladun.com");
        user.setPassword("oleg123");
        user.setRole("USER");
        user.setCourseId(1);
        user.setAmountOfMoney(new BigDecimal("0.0"));
        //System.out.println(user.toString());
        userService.save(user);
        ConnectionManager.closeConnection();
    }
}
