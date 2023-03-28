package demo.eureka.server.userms.service.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseDto<T> {
    private String message;
    private T data;
}