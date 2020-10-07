package com.petz.business;

import com.petz.dto.PetDto;
import com.petz.entities.Client;
import com.petz.entities.Pet;
import com.petz.mapper.PetMapper;
import com.petz.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PetBusiness {

    private PetService petService;

    @Autowired
    public PetBusiness(PetService petService) {
        this.petService = petService;
    }

    public PetDto create(PetDto dto) {
           return PetMapper.entityToVo(petService.create(PetMapper.voToEntity(dto)));
    }

    public PetDto findById(Long id) {
       return Optional.ofNullable(petService.findById(id))
               .map(p -> PetMapper.entityToVo(p))
               .orElse(null);
    }

    public List<PetDto> findAll() {
        List<Pet> pets = petService.findAll();
        return pets.stream()
             .map(p -> PetMapper.entityToVo(p))
             .collect(Collectors.toList());
    }

    public PetDto update(Long id, PetDto petDto) {
        Pet pet = Optional.ofNullable(petService.findById(id))
                .map(p -> new Pet(petDto.getId(), petDto.getName(), petDto.getAge(), new Client(petDto.getClient().getId())))
                .orElse(null);

        return PetMapper.entityToVo(petService.update(pet));
     }

    public void delete(Long id) {
       petService.delete(Optional.ofNullable(petService.findById(id)).orElse(null));
    }
}
