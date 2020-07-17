package jpa;

import jpa.entity.User;
import jpa.repository.UserRepository;
import jpa.repository.impl.UserRepositoryImpl;

public class MainJPA {
    public static void main(String[] args) {
        UserRepository userService = UserRepositoryImpl.getInstance();
        User user = new User();
        user.setFirstName("Гладун");
        user.setLastName("Олег");
        user.setEmail("oleg@gmail.com");
        user.setPassword("oleg123");
        user.setRole("USER");
        user.setCourse(null);
        userService.save(user);
    }
}
