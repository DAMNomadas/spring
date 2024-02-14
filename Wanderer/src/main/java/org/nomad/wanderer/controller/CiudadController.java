package org.nomad.wanderer.controller;

import jakarta.validation.Valid;
import org.nomad.wanderer.model.Ciudad;
import org.nomad.wanderer.model.ciudadDTO.AddCiudadRequest;
import org.nomad.wanderer.model.ciudadDTO.UpdateCiudadRequest;
import org.nomad.wanderer.model.puntuacionDTO.CiudadPuntuacionResponseDTO;
import org.nomad.wanderer.service.CiudadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ciudades")
public class CiudadController {

    @Autowired
    private CiudadServiceImpl service;

    @GetMapping
    public ResponseEntity<List<CiudadPuntuacionResponseDTO>> getAllPuntuaciones(){
        List<CiudadPuntuacionResponseDTO> list = service.getAllPuntuaciones();

        if (list.isEmpty()) {
            return new ResponseEntity<>(list, HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<CiudadPuntuacionResponseDTO> getCiudadPuntuacionByNombre(@PathVariable("nombre") String nombre){
        CiudadPuntuacionResponseDTO ciudadPuntuacion  = service.obtenerPuntuacionCiudad(nombre);

        if (ciudadPuntuacion == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(ciudadPuntuacion, HttpStatus.OK);
        }

    }

    @PostMapping
    public ResponseEntity<Ciudad> addCiudad(@Valid @RequestBody AddCiudadRequest ciudad){

        Ciudad obj = service.addCiudad(ciudad);

        if (obj == null) {
            return new ResponseEntity<>(obj, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(obj, HttpStatus.CREATED);
        }

    }

    @PutMapping
    public ResponseEntity<Ciudad> modificarCiudad(@Valid @RequestBody UpdateCiudadRequest updateCiudadRequest){
        Ciudad obj = service.modificarCiudad(updateCiudadRequest);

        if (obj == null) {
            return new ResponseEntity<>(obj, HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(obj, HttpStatus.OK);
        }

    }

}
