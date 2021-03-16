package com.soservice.api.representationmodel.models.serviceorder;

import com.soservice.domain.model.ServiceOrderStatus;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@Builder
public class ServiceOrderResponse {
    private Long id;
    private String clientName;
    private String description;
    private BigDecimal price;
    private ServiceOrderStatus status;
    private OffsetDateTime createdAt;
    private OffsetDateTime finishedAt;
}
