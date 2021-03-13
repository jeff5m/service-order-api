package com.soservice.api.controller;

import com.soservice.domain.model.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClientController {
    @GetMapping("/clients")
    public List<Client> list() {
        Client c1 = Client.builder()
                .id(1L)
                .name("John")
                .email("john@email.com")
                .phone("00 1234-5678")
                .build();

        Client c2 = Client.builder()
                .id(2L)
                .name("Anna")
                .email("anna@email.com")
                .phone("00 9876-5432")
                .build();

        return Arrays.asList(c1, c2);
    }
}
