package demo.eureka.server.departmentms.service.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class ResponseDTO<T> {
    private String message;
    private Integer code;
    private T data;
}
