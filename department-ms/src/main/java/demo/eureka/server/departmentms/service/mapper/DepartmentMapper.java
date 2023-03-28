package demo.eureka.server.departmentms.service.mapper;

import demo.eureka.server.departmentms.entity.Department;
import demo.eureka.server.departmentms.service.dto.DepartmentDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    Department toEntity(DepartmentDTO departmentDTO);
    DepartmentDTO toDTO(Department department);
}
