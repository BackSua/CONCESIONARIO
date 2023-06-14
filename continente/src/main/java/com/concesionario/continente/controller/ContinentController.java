package com.concesionario.continente.controller;

import com.concesionario.continente.dto.ContinentDTO;
import com.concesionario.continente.dto.ContinentListDTO;
import com.concesionario.continente.dto.ResponseDTO;
import com.concesionario.continente.service.IContinentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
@Api(description = "Continent queries", tags = "Continent Api")
public class ContinentController {
    @Autowired
    IContinentService continentService;

    @PostMapping
    @ApiOperation(value = "Create Contient")
    public ResponseDTO newContient(@RequestBody ContinentDTO continent) throws NullPointerException{
        return continentService.newContinent(continent);
    }

    @GetMapping
    @ApiOperation(value = "list the continents")
    public List<ContinentListDTO> continentListDTOS() throws NullPointerException{
        return continentService.RegisteredContinentList();
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Update the continent")
    public ResponseDTO updateContinent (@PathVariable ("id") Long id, @RequestBody ContinentDTO continent) throws NullPointerException{
        return
                continentService.updateContinent(id,continent);
    }

    @DeleteMapping(value =  "/{id}")
    @ApiOperation(value = "Delete the continent")
    public ResponseDTO deleteContinent(@PathVariable("id") Long id) throws NullPointerException{
        return continentService.deleteContinent(id);
    }
}
