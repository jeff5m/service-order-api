package com.soservice.api.exceptionhandler;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ExceptionDetails {
    private Integer status;
    private String title;
    private LocalDateTime timestamp;
    private List<InvalidField> invalidFields;
}
