package com.soservice.api.controller;

import com.soservice.domain.model.Client;
import com.soservice.domain.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClientController {

    private final ClientRepository clientRepository;

    @GetMapping("/clients")
    public List<Client> listAll() {
        return clientRepository.findAll();
    }
}
