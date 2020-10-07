package com.petz.controller;

import com.petz.business.ClientBusiness;
import com.petz.business.PetBusiness;
import com.petz.dto.ClientDto;
import com.petz.dto.PetDto;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/client")
public class ClientController {

    private ClientBusiness clientBusiness;

    @Autowired
    public ClientController(ClientBusiness petBusiness) {
        this.clientBusiness = petBusiness;
    }

    @GetMapping
    public List<ClientDto> findAll() {
        return clientBusiness.findAll();
    }

    @PostMapping
    public ResponseEntity<ClientDto> create(@RequestBody ClientDto dto) {
        return ResponseEntity.ok().body(this.clientBusiness.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> findById(@PathVariable @NotNull Long id) {
       return new ResponseEntity<>(clientBusiness.findById(id), HttpStatus.OK) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDto> update(@PathVariable Long id, @RequestBody ClientDto clientDto) {
          return ResponseEntity.ok().body(clientBusiness.update(id, clientDto));
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable @NotNull Long id) {
        this.clientBusiness.delete(id);
        return HttpStatus.OK;
    }
}
