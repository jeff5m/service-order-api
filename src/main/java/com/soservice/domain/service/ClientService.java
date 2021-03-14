package com.soservice.domain.service;

import com.soservice.api.exceptionhandler.BadRequestException;
import com.soservice.api.exceptionhandler.EmailAlreadyRegisteredException;
import com.soservice.domain.model.Client;
import com.soservice.domain.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public List<Client> listAll() {
        return clientRepository.findAll();
    }

    public Client findByIdOrThrowBadRequestException(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Client not found!"));
    }

    @Transactional
    public Client save(Client client) {
        Client existentClient = clientRepository.findByEmail(client.getEmail());
        if (existentClient != null && !existentClient.equals(client)) {
            throw new EmailAlreadyRegisteredException("There is already a registered user with this email address");
        }
        return clientRepository.save(client);
    }

    public void delete(Long id) {
        clientRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public Client replace(Long id, Client client) {
        Client savedClient = findByIdOrThrowBadRequestException(id);
        client.setId(savedClient.getId());
        return clientRepository.save(client);
    }
}
