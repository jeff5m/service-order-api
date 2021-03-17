package com.soservice.api.representationmodel.models.serviceorder;

import com.soservice.domain.ValidationGroups;
import com.soservice.domain.model.Client;
import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import java.math.BigDecimal;

@Data
@Builder
public class ServiceOrderPostRequest {

    @Valid
    @NotNull(groups = ValidationGroups.ClientId.class)
    @ConvertGroup(from = Default.class, to = ValidationGroups.ClientId.class)
    private Client client;

    @NotBlank
    private String description;

    @NotNull
    private BigDecimal price;
}
