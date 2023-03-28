package demo.eureka.server.userms.service;

import demo.eureka.server.userms.entity.User;
import demo.eureka.server.userms.service.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDto userDto);
    UserDto toDTO(User user);
}
