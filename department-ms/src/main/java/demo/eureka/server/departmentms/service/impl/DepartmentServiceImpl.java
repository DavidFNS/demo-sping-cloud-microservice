package demo.eureka.server.departmentms.service.impl;

import demo.eureka.server.departmentms.entity.Department;
import demo.eureka.server.departmentms.repository.DepartmentRepository;
import demo.eureka.server.departmentms.service.DepartmentService;
import demo.eureka.server.departmentms.service.dto.DepartmentDTO;
import demo.eureka.server.departmentms.service.mapper.DepartmentMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentMapper departmentMapper;
    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO department) {
        Department savedDepartment = departmentRepository.save(departmentMapper.toEntity(department));
        log.debug("Result saved department: {}", department);
        return departmentMapper.toDTO(savedDepartment);
    }

    @Override
    public DepartmentDTO getDepartmentById(Long departmentId) {
        log.debug("Request to get department by id: {}", departmentId);
        Optional<Department> departmentOptional = departmentRepository.findById(departmentId);
        return departmentOptional.map(departmentMapper::toDTO).orElse(null);

    }
}