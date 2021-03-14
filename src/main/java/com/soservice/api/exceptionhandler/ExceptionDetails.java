package com.soservice.api.exceptionhandler;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ExceptionDetails {
    private Integer status;
    private String title;
    private LocalDateTime timestamp;
}
