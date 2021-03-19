package com.soservice.api.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ServiceOrderException extends RuntimeException {
    public ServiceOrderException(String message) {
        super(message);
    }
}
