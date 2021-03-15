package com.soservice.domain.service;

import com.soservice.api.exceptionhandler.BadRequestException;
import com.soservice.api.representationmodel.ServiceOrderMapper;
import com.soservice.api.representationmodel.models.serviceorder.ServiceOrderClientResponse;
import com.soservice.domain.model.Client;
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
    private final ClientService clientService;

    public List<ServiceOrderClientResponse> listAll() {
        List<ServiceOrder> serviceOrderList = serviceOrderRepository.findAll();
        return ServiceOrderMapper.INSTANCE.toListOfServiceOrderClientResponse(serviceOrderList);
    }

    public ServiceOrderClientResponse findById(Long id) {
        ServiceOrder serviceOrder = serviceOrderRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Service Order not found!"));
        return ServiceOrderMapper.INSTANCE.toServiceOrderClientResponse(serviceOrder);
    }

    public ServiceOrderClientResponse save(ServiceOrder serviceOrder) {
        Client client = clientService.findByIdOrThrowBadRequestException(serviceOrder.getClient().getId());

        serviceOrder.setClient(client);
        serviceOrder.setStatus(ServiceOrderStatus.OPEN);
        serviceOrder.setCreatedAt(OffsetDateTime.now());
        return ServiceOrderMapper.INSTANCE.toServiceOrderClientResponse(serviceOrderRepository.save(serviceOrder));
    }
}
