package service;

import entity.User;

import java.util.Optional;

public interface UserService extends CrudService<User, Integer> {

    Optional<User> findByEmail(String email);

}
