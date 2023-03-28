package demo.eureka.server.userms.controller;

import demo.eureka.server.userms.entity.User;
import demo.eureka.server.userms.service.UserService;
import demo.eureka.server.userms.service.dto.DepartmentDto;
import demo.eureka.server.userms.service.dto.ResponseDto;
import demo.eureka.server.userms.service.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto user) {
        UserDto savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseDto<DepartmentDto>> getDepartmentByUserId(@PathVariable("id") Long userId) {
        ResponseDto<DepartmentDto> responseDto = userService.getDepartmentWithFeignClient(userId);
        return ResponseEntity.ok(responseDto);
    }
}
