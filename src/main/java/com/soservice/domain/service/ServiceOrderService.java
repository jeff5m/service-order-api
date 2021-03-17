package com.soservice.domain.service;

import com.soservice.api.exceptionhandler.BadRequestException;
import com.soservice.api.representationmodel.ServiceOrderMapper;
import com.soservice.api.representationmodel.models.serviceorder.ServiceOrderPostRequest;
import com.soservice.api.representationmodel.models.serviceorder.ServiceOrderResponse;
import com.soservice.domain.model.Client;
import com.soservice.domain.model.ServiceOrder;
import com.soservice.domain.model.ServiceOrderStatus;
import com.soservice.domain.repository.ServiceOrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class ServiceOrderService {

    private final ServiceOrderRepository serviceOrderRepository;
    private final ClientService clientService;

    public List<ServiceOrderResponse> listAll() {
        List<ServiceOrder> serviceOrderList = serviceOrderRepository.findAll();
        return ServiceOrderMapper.INSTANCE.toListOfServiceOrderResponse(serviceOrderList);
    }

    public ServiceOrderResponse findById(Long id) {
        ServiceOrder serviceOrder = serviceOrderRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Service Order not found!"));
        return ServiceOrderMapper.INSTANCE.toServiceOrderResponse(serviceOrder);
    }

    public ServiceOrderResponse save(ServiceOrderPostRequest serviceOrderPostRequest) {
        ServiceOrder serviceOrder = ServiceOrderMapper.INSTANCE.toServiceOrder(serviceOrderPostRequest);
        Client client = clientService.findByIdOrThrowBadRequestException(serviceOrderPostRequest.getClient().getId());
        log.info(client);
        serviceOrder.setClient(client);
        serviceOrder.setStatus(ServiceOrderStatus.OPEN);
        serviceOrder.setCreatedAt(OffsetDateTime.now());
        return ServiceOrderMapper.INSTANCE.toServiceOrderResponse(serviceOrderRepository.save(serviceOrder));
    }
}
