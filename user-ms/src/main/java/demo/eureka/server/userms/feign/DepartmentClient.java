package demo.eureka.server.userms.feign;

import demo.eureka.server.userms.service.dto.DepartmentDto;
import demo.eureka.server.userms.service.dto.ResponseDto;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
//@LoadBalancerClient(name = "DEPARTMENT-SERVICE")
public interface DepartmentClient {

    @GetMapping("/api/departments/{userId}")
    ResponseEntity<ResponseDto<DepartmentDto>> getDepartment(@PathVariable Long userId);
}
