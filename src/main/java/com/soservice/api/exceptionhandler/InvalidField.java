package com.soservice.api.exceptionhandler;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InvalidField {
    private String name;
    private String message;
}
