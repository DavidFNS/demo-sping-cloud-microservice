package demo.eureka.server.departmentms.controller;

import demo.eureka.server.departmentms.entity.Department;
import demo.eureka.server.departmentms.service.DepartmentService;
import demo.eureka.server.departmentms.service.dto.DepartmentDTO;
import demo.eureka.server.departmentms.service.dto.ResponseDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
@Slf4j
public class DepartmentController {

    private final DepartmentService departmentService;
    private final Environment environment;

    @PostMapping
    public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO department) {
        log.debug("Request to save department: {}", department);
        DepartmentDTO savedDepartment = departmentService.saveDepartment(department);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseDTO<DepartmentDTO>> getDepartmentById(@PathVariable("id") Long departmentId) {
        DepartmentDTO department = departmentService.getDepartmentById(departmentId);
        ResponseDTO<DepartmentDTO> response = ResponseDTO.<DepartmentDTO>builder()
                .code(0)
                .message(environment.getProperty("server.port"))
                .data(department)
                .build();

        log.debug("Result get department: {}", response);
        return ResponseEntity.ok(response);
    }
}