package com.soservice.domain.service;

import com.soservice.api.exceptionhandler.BadRequestException;
import com.soservice.api.representationmodel.ServiceOrderMapper;
import com.soservice.api.representationmodel.models.serviceorder.ServiceOrderPostRequest;
import com.soservice.api.representationmodel.models.serviceorder.ServiceOrderResponse;
import com.soservice.domain.model.ServiceOrder;
import com.soservice.domain.model.ServiceOrderStatus;
import com.soservice.domain.repository.ServiceOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceOrderService {

    private final ServiceOrderRepository serviceOrderRepository;
    private final ServiceOrderMapper serviceOrderMapper;

    public List<ServiceOrderResponse> listAll() {
        List<ServiceOrder> serviceOrderList = serviceOrderRepository.findAll();
        return serviceOrderMapper.toListOfServiceOrderResponse(serviceOrderList);
    }

    public ServiceOrderResponse findById(Long id) {
        ServiceOrder serviceOrder = serviceOrderRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Service Order not found!"));
        return serviceOrderMapper.toServiceOrderResponse(serviceOrder);
    }

    public ServiceOrderResponse save(ServiceOrderPostRequest serviceOrderPostRequest) {
        ServiceOrder serviceOrder = serviceOrderMapper.toServiceOrder(serviceOrderPostRequest);
        serviceOrder.setStatus(ServiceOrderStatus.OPEN);
        serviceOrder.setCreatedAt(OffsetDateTime.now());
        return serviceOrderMapper.toServiceOrderResponse(serviceOrderRepository.save(serviceOrder));
    }
}
