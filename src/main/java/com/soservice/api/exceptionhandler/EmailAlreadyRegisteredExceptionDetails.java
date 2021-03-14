package com.soservice.api.exceptionhandler;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@SuperBuilder
public class EmailAlreadyRegisteredExceptionDetails extends ExceptionDetails {
    private final String details;
}
