package com.concesionario.continente.service;

import com.concesionario.continente.dto.ContinentDTO;
import com.concesionario.continente.dto.ContinentListDTO;
import com.concesionario.continente.dto.ResponseDTO;

import java.util.List;

public interface IContinentService {

    ResponseDTO newContinent(ContinentDTO continent) throws NullPointerException;
    List<ContinentListDTO> RegisteredContinentList () throws NullPointerException;
    ResponseDTO deleteContinent(Long id) throws NullPointerException;
    ResponseDTO updateContinent(Long id, ContinentDTO continent) throws NullPointerException;

}
