package com.petz.mapper;

import com.petz.dto.ClientDto;
import com.petz.entities.Client;
import org.modelmapper.ModelMapper;

public class ClientMapper {

    public static Client voToEntity(ClientDto dto){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, Client.class);
    }

    public static ClientDto entityToVo(Client client){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(client, ClientDto.class);
    }
}
