package com.concesionario.continente.service.Impl;

import com.concesionario.continente.dto.ContinentDTO;
import com.concesionario.continente.dto.ContinentListDTO;
import com.concesionario.continente.dto.ResponseDTO;
import com.concesionario.continente.entity.ContinentEntity;
import com.concesionario.continente.repository.ContinentRepository;
import com.concesionario.continente.service.IContinentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ContinentService implements IContinentService {
    @Autowired
    ContinentRepository repository;

    @Override
    public ResponseDTO newContinent(ContinentDTO continent) throws NullPointerException {
        if (Objects.isNull(continent)){
            throw new NullPointerException("Input parameter cannot be null");
        }
        ModelMapper mapper = new ModelMapper();
        ContinentEntity continentEntity = mapper.map(continent, ContinentEntity.class);
        repository.save(continentEntity);
        ResponseDTO respone = new ResponseDTO();
        respone.setMessage("You have successfully created the continent");

        return respone;
    }

    @Override
    public List<ContinentListDTO> RegisteredContinentList() throws NullPointerException {
        List<ContinentEntity> listContinent = repository.findAll();
        if (listContinent.isEmpty()){
            throw new NullPointerException("There are no continents to teach");
        }
        ModelMapper mapper  = new ModelMapper();
        List<ContinentListDTO> continentList = listContinent.stream().map(
                continentEntity -> {
                    ContinentListDTO continentListDTO = mapper.map(continentEntity, ContinentListDTO.class);
                    return continentListDTO;
                }).collect(Collectors.toList());
        return continentList;
    }

    @Override
    public ResponseDTO deleteContinent(Long id) throws NullPointerException {
        if (id == null){
            throw new NullPointerException("Input parameter cannot be null");
        }
        ContinentEntity idContinent = repository.findById(id).orElseThrow(
                () -> new NullPointerException("No continent exists or has not been found with that id")
        );
        repository.deleteById(id);
        ResponseDTO response = new ResponseDTO();
        response.setMessage("The continent has been successfully removed");
        return response;
    }

    @Override
    public ResponseDTO updateContinent(Long id,ContinentDTO continent) throws NullPointerException {
        if (Objects.isNull(continent) || id == null){
            throw new NullPointerException("Input parameter cannot be null");
        }
        ContinentEntity idContinentEntity = repository.findById(id).orElseThrow(
                () -> new NullPointerException("No continent exists or has not been found with that id")
        );
        ModelMapper mapper = new ModelMapper();
        ContinentEntity newContinent = mapper.map( idContinentEntity , ContinentEntity.class);
        newContinent.setCode(continent.getCode());
        newContinent.setDescription(continent.getDescription());
        newContinent.setStatus(continent.getStatus());
        repository.save(newContinent);
        ResponseDTO response = new ResponseDTO();
        response.setMessage("The continent has been successfully updated");
        return response;
    }
}
