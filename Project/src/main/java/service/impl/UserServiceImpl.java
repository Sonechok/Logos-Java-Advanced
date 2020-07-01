package service.impl;

import entity.User;
import org.apache.log4j.Logger;
import repository.CourseRepository;
import repository.UserRepository;
import repository.impl.UserRepositoryImpl;
import service.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private static Logger log = Logger.getLogger(UserServiceImpl.class);

    private UserRepository userRepository;


    private static UserServiceImpl instance;

    private UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static UserServiceImpl getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl(UserRepositoryImpl.getInstance());
        }
        return instance;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        log.debug("Find user by email " + email);
        return userRepository.findByEmail(email);
    }

    @Override
    public void save(User user) {
        log.debug("Save new user " + user);
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        log.debug("Update user " + user);
        userRepository.update(user);
    }

    @Override
    public List<User> findAll() {
        log.debug("Find all users");
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Integer id) {
        log.debug("Find user by id " + id);
        return userRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        log.debug("Delete user by id " + id);
        userRepository.deleteById(id);
    }
}
