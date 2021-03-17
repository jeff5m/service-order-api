package com.soservice.api.representationmodel.models.serviceorder;

import com.soservice.api.representationmodel.models.client.ClientServiceOrderPostRequest;
import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
public class ServiceOrderPostRequest {

    @Valid
    private ClientServiceOrderPostRequest client;

    @NotBlank
    private String description;

    @NotNull
    private BigDecimal price;
}
