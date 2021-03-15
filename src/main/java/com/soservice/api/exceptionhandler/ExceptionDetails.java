package com.soservice.api.exceptionhandler;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.OffsetDateTime;

@Data
@SuperBuilder
public class ExceptionDetails {
    private Integer status;
    private String title;
    private OffsetDateTime timestamp;
}
