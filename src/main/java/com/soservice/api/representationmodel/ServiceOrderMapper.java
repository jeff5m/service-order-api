package com.soservice.api.representationmodel;

import com.soservice.api.representationmodel.models.serviceorder.ServiceOrderPostRequest;
import com.soservice.api.representationmodel.models.serviceorder.ServiceOrderResponse;
import com.soservice.domain.model.ServiceOrder;
import com.soservice.domain.service.ClientService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ClientService.class})
public interface ServiceOrderMapper {

    ServiceOrderResponse toServiceOrderResponse(ServiceOrder serviceOrder);

    List<ServiceOrderResponse> toListOfServiceOrderResponse(List<ServiceOrder> serviceOrder);

    @Mapping(target = "status", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "finishedAt", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(source = "client.id", target = "client")
    ServiceOrder toServiceOrder(ServiceOrderPostRequest serviceOrderPostRequest);
}
