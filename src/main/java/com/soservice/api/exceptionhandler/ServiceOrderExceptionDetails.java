package com.soservice.api.exceptionhandler;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class ServiceOrderExceptionDetails extends ExceptionDetails {
    private final String details;
}
