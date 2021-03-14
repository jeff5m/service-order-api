package com.soservice.api.exceptionhandler;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@Data
@SuperBuilder
public class ExceptionDetails {
    private Integer status;
    private String title;
    private LocalDateTime timestamp;
}
