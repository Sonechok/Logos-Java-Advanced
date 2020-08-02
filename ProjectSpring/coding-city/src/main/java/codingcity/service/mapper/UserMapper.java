package codingcity.service.mapper;

import codingcity.dto.UserDTO;
import codingcity.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO (User user);

    User toEntity (UserDTO userDTO);
}
