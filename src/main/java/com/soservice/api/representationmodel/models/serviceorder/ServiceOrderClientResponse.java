package com.soservice.api.representationmodel.models.serviceorder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServiceOrderClientResponse {
    private Long id;
    private String name;
}
