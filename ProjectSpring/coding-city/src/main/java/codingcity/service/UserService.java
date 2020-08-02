package codingcity.service;

import codingcity.dto.UserDTO;
import codingcity.entity.User;

import java.util.Optional;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(User user);

    UserDTO findByEmail(String email);
}
