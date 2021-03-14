package com.soservice.api.controller;

import com.soservice.domain.model.ServiceOrder;
import com.soservice.domain.service.ServiceOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("service-order")
@RequiredArgsConstructor
public class ServiceOrderController {

    private final ServiceOrderService serviceOrderService;

    @PostMapping
    public ResponseEntity<ServiceOrder> save(@RequestBody ServiceOrder serviceOrder) {
        return new ResponseEntity<>(serviceOrderService.save(serviceOrder), HttpStatus.CREATED);
    }
}
