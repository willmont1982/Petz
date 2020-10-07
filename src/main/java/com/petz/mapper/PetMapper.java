package com.petz.mapper;

import com.petz.dto.PetDto;
import com.petz.entities.Pet;
import org.modelmapper.ModelMapper;

public class PetMapper {

    public static Pet voToEntity(PetDto dto){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, Pet.class);
    }

    public static PetDto entityToVo(Pet pet){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(pet, PetDto.class);
    }
}
