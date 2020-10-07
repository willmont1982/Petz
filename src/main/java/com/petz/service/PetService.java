package com.petz.service;

import com.petz.entities.Pet;
import com.petz.repository.PetRepository;
import com.petz.util.PetValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class PetService {

    private PetRepository petRepository;
    private PetValidation petValidation;

    @Autowired
    public PetService(PetRepository petRepository, PetValidation petValidation) {
        this.petRepository = petRepository;
        this.petValidation = petValidation;
    }

    @Transactional
    public Pet create(Pet pet) {
        this.petValidation.valid(pet);
        return petRepository.save(pet);
    }

    @Transactional(readOnly = true)
    public Pet findById(Long id) {
        Pet pet = petRepository.findById(id).orElse(null);
        this.petValidation.notFound(pet);
        return pet;
    }

    @Transactional(readOnly = true)
    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    @Transactional
    public Pet update(Pet pet) {
        this.petValidation.valid(pet);
        return petRepository.save(pet);
    }

    @Transactional
    public void delete(Pet pet) {
        petRepository.delete(pet);
    }
}
