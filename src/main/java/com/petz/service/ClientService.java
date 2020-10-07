package com.petz.service;

import com.petz.entities.Client;
import com.petz.entities.Pet;
import com.petz.repository.ClientRepository;
import com.petz.repository.PetRepository;
import com.petz.util.ClientValidation;
import com.petz.util.PetValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ClientService {

    private ClientRepository clientRepository;
    private ClientValidation clientValidation;

    @Autowired
    public ClientService(ClientRepository clientRepository, ClientValidation clientValidation) {
        this.clientRepository = clientRepository;
        this.clientValidation = clientValidation;
    }

    @Transactional
    public Client create(Client client) {
        this.clientValidation.valid(client);
        return clientRepository.save(client);
    }

    @Transactional(readOnly = true)
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Client findById(Long id) {
        Client client = clientRepository.findById(id).orElse(null);
        this.clientValidation.notFound(client);
        return client;
    }

    @Transactional
    public Client update(Client client) {
        this.clientValidation.valid(client);
        return clientRepository.save(client);
    }

    @Transactional
    public void delete(Client client) {
        clientRepository.delete(client);
    }
}
