package com.soservice.api.exceptionhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionDetails> handlerBadRequestException(BadRequestException badRequestException) {
        return new ResponseEntity<>(
                BadRequestExceptionDetails.builder()
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Bad Request Exception. Check Documentation")
                        .timestamp(OffsetDateTime.now())
                        .details(badRequestException.getMessage())
                        .build(), HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(EmailAlreadyRegisteredException.class)
    public ResponseEntity<EmailAlreadyRegisteredExceptionDetails> handlerEmailAlreadyRegisteredException(EmailAlreadyRegisteredException emailAlreadyRegisteredException) {
        return new ResponseEntity<>(
                EmailAlreadyRegisteredExceptionDetails.builder()
                        .status(HttpStatus.CONFLICT.value())
                        .title("Email Already Registered Exception. Check Documentation")
                        .timestamp(OffsetDateTime.now())
                        .details(emailAlreadyRegisteredException.getMessage())
                        .build(), HttpStatus.CONFLICT
        );
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<InvalidField> invalidFieldList = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            invalidFieldList.add(
                    InvalidField.builder()
                            .name(((FieldError) error).getField())
                            .message(error.getDefaultMessage())
                            .build()
            );
        }

        return new ResponseEntity<>(
                ArgumentsValidationExceptionDetails.builder()
                        .status(status.value())
                        .title("One or more fields are invalid! Please, fill all the fields correctly")
                        .timestamp(OffsetDateTime.now())
                        .invalidFields(invalidFieldList)
                        .build(), HttpStatus.BAD_REQUEST);
    }
}
