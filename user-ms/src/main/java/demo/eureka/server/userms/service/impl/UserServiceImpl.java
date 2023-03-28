package demo.eureka.server.userms.service.impl;

import demo.eureka.server.userms.entity.User;
import demo.eureka.server.userms.feign.DepartmentClient;
import demo.eureka.server.userms.repository.UserRepository;
import demo.eureka.server.userms.service.UserMapper;
import demo.eureka.server.userms.service.UserService;
import demo.eureka.server.userms.service.dto.DepartmentDto;
import demo.eureka.server.userms.service.dto.ResponseDto;
import demo.eureka.server.userms.service.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;
    private final DepartmentClient departmentClient;
    private final UserMapper userMapper;

    @Override
    public UserDto saveUser(UserDto user) {
        User savedUser = userRepository.save(userMapper.toEntity(user));
        return userMapper.toDTO(savedUser);
    }

    @Override
    public ResponseDto<DepartmentDto> getDepartment(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        assert user != null;
        log.debug("Result get user by id: {}. User: {}", user.getDepartmentId(), userId);

        ResponseEntity<ResponseDto<DepartmentDto>> responseEntity = restTemplate
                .exchange(
                        "http://DEPARTMENT-SERVICE/api/departments/" + Objects.requireNonNull(user).getDepartmentId(),
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<>() {}
                );

        ResponseDto<DepartmentDto> response = responseEntity.getBody();
        System.out.println(responseEntity.getStatusCode());
        assert response != null;
        System.out.println("Successfully get department: " + response.getData());

        return response;
    }

    @Override
    public ResponseDto<DepartmentDto> getDepartmentWithFeignClient(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        assert user != null;
        log.debug("Result get user by id: {}. User: {}", user.getDepartmentId(), userId);

        ResponseDto<DepartmentDto> response = departmentClient.getDepartment(userId).getBody();
        assert response != null;
        System.out.println("Successfully get department: " + response.getData());

        return response;
    }
}
