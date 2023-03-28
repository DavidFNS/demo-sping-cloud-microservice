package demo.eureka.server.departmentms.service;

import demo.eureka.server.departmentms.entity.Department;
import demo.eureka.server.departmentms.service.dto.DepartmentDTO;

public interface DepartmentService {
    DepartmentDTO saveDepartment(DepartmentDTO department);

    DepartmentDTO getDepartmentById(Long departmentId);
}
