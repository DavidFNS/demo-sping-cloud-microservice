package demo.eureka.server.departmentms.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DepartmentDTO {
    private Long id;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}
