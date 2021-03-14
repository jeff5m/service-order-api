package com.soservice.api.exceptionhandler;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@SuperBuilder
public class ArgumentsValidationExceptionDetails  extends ExceptionDetails{
    private final List<InvalidField> invalidFields;

}
