package com.soservice.api.controller;

import com.soservice.api.representationmodel.models.ServiceOrderClientResponse;
import com.soservice.domain.model.ServiceOrder;
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
    public ResponseEntity<List<ServiceOrder>> listAll() {
        return new ResponseEntity<>(serviceOrderService.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceOrderClientResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(serviceOrderService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ServiceOrderClientResponse> save(@Valid
                                                           @RequestBody ServiceOrder serviceOrder) {
        return new ResponseEntity<>(serviceOrderService.save(serviceOrder), HttpStatus.CREATED);
    }
}
