package com.soservice.api.representationmodel.models.client;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ClientServiceOrderPostRequest {
    @NotNull
    private Long id;
}
