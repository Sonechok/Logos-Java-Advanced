package repository;

import entity.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer>{
    Optional<User> findByEmail(String email);
}
