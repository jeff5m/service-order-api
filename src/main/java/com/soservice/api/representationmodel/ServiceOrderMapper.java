package com.soservice.api.representationmodel;

import com.soservice.api.representationmodel.models.ServiceOrderClientResponse;
import com.soservice.domain.model.ServiceOrder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ServiceOrderMapper {
    public static final ServiceOrderMapper INSTANCE = Mappers.getMapper(ServiceOrderMapper.class);

    @Mapping(source="client.name", target = "clientName")
    public abstract ServiceOrderClientResponse toServiceOrderClientResponse(ServiceOrder serviceOrder);
}