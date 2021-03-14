package com.soservice.domain.service;

import com.soservice.domain.model.Client;
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
    private final ClientService clientService;

    public ServiceOrder save(ServiceOrder serviceOrder) {
        Client client = clientService.findByIdOrThrowBadRequestException(serviceOrder.getClient().getId());

        serviceOrder.setClient(client);
        serviceOrder.setStatus(ServiceOrderStatus.OPEN);
        serviceOrder.setCreatedAt(LocalDateTime.now());
        return serviceOrderRepository.save(serviceOrder);
    }
}
