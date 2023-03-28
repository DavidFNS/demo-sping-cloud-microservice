package demo.eureka.server.userms.service;

import demo.eureka.server.userms.entity.User;
import demo.eureka.server.userms.service.dto.DepartmentDto;
import demo.eureka.server.userms.service.dto.ResponseDto;
import demo.eureka.server.userms.service.dto.UserDto;

public interface UserService {
    UserDto saveUser(UserDto user);

    ResponseDto<DepartmentDto> getDepartment(Long userId);
    ResponseDto<DepartmentDto> getDepartmentWithFeignClient(Long userId);
}
