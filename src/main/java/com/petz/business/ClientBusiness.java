package com.petz.business;

import com.petz.dto.ClientDto;
import com.petz.dto.DocumentDto;
import com.petz.dto.PetDto;
import com.petz.entities.Address;
import com.petz.entities.Client;
import com.petz.entities.Document;
import com.petz.mapper.ClientMapper;
import com.petz.mapper.PetMapper;
import com.petz.service.ClientService;
import com.petz.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ClientBusiness {

    private ClientService clientService;

    @Autowired
    public ClientBusiness(ClientService clientService) {
        this.clientService = clientService;
    }

    public ClientDto create(ClientDto dto) {
           return ClientMapper.entityToVo(clientService.create(ClientMapper.voToEntity(dto)));
    }

        public List<ClientDto> findAll() {
        List<Client> pets = clientService.findAll();
        return pets.stream()
             .map(p -> ClientMapper.entityToVo(p))
             .collect(Collectors.toList());
    }

    public ClientDto findById(Long id) {
       return Optional.ofNullable(clientService.findById(id))
               .map(p -> ClientMapper.entityToVo(p))
               .orElse(null);
    }

    public ClientDto update(Long id, ClientDto dto) {
        Client client = Optional.ofNullable(clientService.findById(id))
                .map(p -> new Client(dto.getId(), dto.getName(), mapAdress(dto), mapDocuments(dto)))
                .orElse(null);

        return ClientMapper.entityToVo(clientService.update(client));
     }

    private List<Document> mapDocuments(ClientDto dto) {
       return dto.getDocuments().stream()
                .map(doc -> new Document(doc.getId(), doc.getNumber(), doc.getType()))
                .collect(Collectors.toList());
    }

    private Address mapAdress(ClientDto dto) {
      return  new Address(dto.getAddress().getId(), dto.getAddress().getCountry(), dto.getAddress().getCity());
    }

    public void delete(Long id) {
        clientService.delete(Optional.ofNullable(clientService.findById(id)).orElse(null));
    }
}
