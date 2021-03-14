package com.soservice.domain.service;

import com.soservice.domain.model.ServiceOrder;
import com.soservice.domain.model.ServiceOrderStatus;
import com.soservice.domain.repository.ServiceOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ServiceOrderService {

    private final ServiceOrderRepository serviceOrderRepository;

    public ServiceOrder save(ServiceOrder serviceOrder) {
        serviceOrder.setStatus(ServiceOrderStatus.OPEN);
        serviceOrder.setCreatedAt(LocalDateTime.now());
        return serviceOrderRepository.save(serviceOrder);
    }
}
