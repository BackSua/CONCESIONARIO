package com.concesionario.continente.service.Impl;

import com.concesionario.continente.dto.ContinentDTO;
import com.concesionario.continente.dto.ContinentListDTO;
import com.concesionario.continente.dto.ResponseDTO;
import com.concesionario.continente.entity.ContinentEntity;
import com.concesionario.continente.repository.ContinentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ContinentServiceTest {

    @Mock
    private ContinentRepository continentRepository;
    @InjectMocks
    @Spy
    private ContinentService continentService;

    @Test
    void newContinent() {
        ContinentDTO continentDTO = new ContinentDTO();
        ContinentEntity continentEntity = new ContinentEntity();

        Mockito.when(continentRepository.save(any(ContinentEntity.class))).thenReturn(continentEntity);

        ResponseDTO response = continentService.newContinent(continentDTO);
        Assertions.assertNotNull(response);
    }

    @Test
    void registeredContinentList() {
        List<ContinentEntity> continentEntityList = new ArrayList<ContinentEntity>();
        ContinentEntity continentEntity = new ContinentEntity();
        continentEntityList.add(continentEntity);
        Mockito.when(continentRepository.findAll()).thenReturn(continentEntityList);
        List<ContinentListDTO> listDTOS = continentService.RegisteredContinentList();
        Assertions.assertNotNull(listDTOS);
    }

    @Test
    void deleteContinent() {
        ContinentEntity continentEntity = new ContinentEntity();
        continentEntity.setId(1L);

        Mockito.when(continentRepository.findById(1L)).thenReturn(Optional.of(continentEntity));

        ResponseDTO responseDTO = continentService.deleteContinent(1L);
        Assertions.assertNotNull(responseDTO);
    }

    @Test
    void updateContinent() {
        ContinentDTO continentDTO = new ContinentDTO();
        ContinentEntity continentEntity = new ContinentEntity();

        Mockito.when(continentRepository.findById(1L)).thenReturn(Optional.of(continentEntity));
        Mockito.when(continentRepository.save(any(ContinentEntity.class))).thenReturn(continentEntity);

        ResponseDTO responseDTO = continentService.updateContinent(1L, continentDTO);
        Assertions.assertNotNull(responseDTO);
    }
}