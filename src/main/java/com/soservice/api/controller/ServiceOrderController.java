package com.soservice.api.controller;

import com.soservice.api.representationmodel.models.serviceorder.ServiceOrderPostRequest;
import com.soservice.api.representationmodel.models.serviceorder.ServiceOrderResponse;
import com.soservice.domain.service.ServiceOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("service-order")
@RequiredArgsConstructor
public class ServiceOrderController {

    private final ServiceOrderService serviceOrderService;

    @GetMapping
    public ResponseEntity<List<ServiceOrderResponse>> listAll() {
        return new ResponseEntity<>(serviceOrderService.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceOrderResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(serviceOrderService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ServiceOrderResponse> save(@Valid
                                                     @RequestBody ServiceOrderPostRequest serviceOrderPostRequest) {
        return new ResponseEntity<>(serviceOrderService.save(serviceOrderPostRequest), HttpStatus.CREATED);
    }
}
