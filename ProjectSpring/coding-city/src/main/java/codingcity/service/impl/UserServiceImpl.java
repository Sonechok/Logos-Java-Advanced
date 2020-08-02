package codingcity.service.impl;

import codingcity.dto.UserDTO;
import codingcity.entity.User;
import codingcity.error.ResourceNotFoundException;
import codingcity.repository.UserRepository;
import codingcity.service.UserService;
import codingcity.service.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public UserDTO createUser(UserDTO userDTO) {
        if (userDTO.getAmountOfMoney() == null){
            userDTO.setAmountOfMoney(0);
        }
        User user = userMapper.toEntity(userDTO);
        return userMapper.toDTO(userRepository.save(user));
    }

    @Override
    @Transactional
    public UserDTO updateUser(User user) {
        if (user.getAmountOfMoney() == null){
            user.setAmountOfMoney(0);
        }
        User userToUpdate = userRepository.getOne(user.getId());
        BeanUtils.copyProperties(user, userToUpdate, "email", "amountOfMoney");
        userToUpdate.setAmountOfMoney(user.getAmountOfMoney());
        return userMapper.toDTO(userRepository.save(userToUpdate));
    }

    @Override
    @Transactional
    public UserDTO findByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(()->new ResourceNotFoundException("email",email));
        return userMapper.toDTO(user);
    }
}
