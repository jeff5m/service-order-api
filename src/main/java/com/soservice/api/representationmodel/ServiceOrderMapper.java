package com.soservice.api.representationmodel;

import com.soservice.api.representationmodel.models.serviceorder.ServiceOrderPostRequest;
import com.soservice.api.representationmodel.models.serviceorder.ServiceOrderResponse;
import com.soservice.domain.model.ServiceOrder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ServiceOrderMapper {

    public static final ServiceOrderMapper INSTANCE = Mappers.getMapper(ServiceOrderMapper.class);

    public abstract ServiceOrderResponse toServiceOrderResponse(ServiceOrder serviceOrder);

    public abstract List<ServiceOrderResponse> toListOfServiceOrderResponse(List<ServiceOrder> serviceOrder);

    @Mapping(target = "client.id", source = "client.id")
    public abstract ServiceOrder toServiceOrder(ServiceOrderPostRequest serviceOrderPostRequest);
}
