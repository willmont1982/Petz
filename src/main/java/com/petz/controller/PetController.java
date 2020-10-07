package com.petz.controller;

import com.petz.business.PetBusiness;
import com.petz.dto.PetDto;
import com.petz.entities.Pet;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/petz")
public class PetController {

    private PetBusiness petBusiness;

    @Autowired
    public PetController(PetBusiness petBusiness) {
        this.petBusiness = petBusiness;
    }

    @GetMapping
    public List<PetDto> findAll() {
        return petBusiness.findAll();
    }

    @PostMapping
    public ResponseEntity<PetDto> create(@RequestBody PetDto dto) {
        return ResponseEntity.ok().body(this.petBusiness.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetDto> findById(@PathVariable @NotNull Long id) {
       return new ResponseEntity<>(petBusiness.findById(id), HttpStatus.OK) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetDto> update(@PathVariable Long id, @RequestBody PetDto petDto) {
          return ResponseEntity.ok().body(petBusiness.update(id, petDto));
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable @NotNull Long id) {
        this.petBusiness.delete(id);
        return HttpStatus.OK;
    }
}
