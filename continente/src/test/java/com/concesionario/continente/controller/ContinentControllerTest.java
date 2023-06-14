package com.concesionario.continente.controller;

import com.concesionario.continente.dto.ContinentDTO;
import com.concesionario.continente.dto.ContinentListDTO;
import com.concesionario.continente.dto.ResponseDTO;
import com.concesionario.continente.service.Impl.ContinentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ContinentControllerTest {

    @Mock
    ContinentService continentService;
    @InjectMocks
    ContinentController continentController;

    @Test
    void newContient() {
        ContinentDTO continent  = Mockito.mock(ContinentDTO.class);
        ResponseDTO responseDTO = Mockito.mock(ResponseDTO.class);
        Mockito.when(continentService.newContinent(continent))
                .thenReturn(responseDTO);
        ResponseDTO continentDTO = continentController.newContient(continent);
        Assertions.assertNotNull(continentDTO);
    }

    @Test
    void continentListDTOS() {
        List<ContinentListDTO> continentListDTOS =  Mockito.mock(List.class);
        ResponseDTO responseDTO = Mockito.mock(ResponseDTO.class);
        Mockito.when(continentService.RegisteredContinentList())
               .thenReturn(continentListDTOS);
        List<ContinentListDTO> continentListDTOS1 = continentController.continentListDTOS();
        Assertions.assertNotNull(continentListDTOS1);
    }

    @Test
    void updateContinent() {
        Long id = 1L;
        ContinentDTO continent =  Mockito.mock(ContinentDTO.class);
        ResponseDTO responseDTO = Mockito.mock(ResponseDTO.class);
        Mockito.when(continentService.updateContinent(id,continent))
                .thenReturn(responseDTO);
        ResponseDTO continentDTO = continentController.updateContinent(id,continent);
        Assertions.assertNotNull(continentDTO);
    }

    @Test
    void deleteContinent() {
        Long id = 1L;
        ResponseDTO responseDTO = Mockito.mock(ResponseDTO.class);
        Mockito.when(continentService.deleteContinent(id))
               .thenReturn(responseDTO);
        ResponseDTO continentDTO = continentController.deleteContinent(id);
        Assertions.assertNotNull(continentDTO);
    }
}