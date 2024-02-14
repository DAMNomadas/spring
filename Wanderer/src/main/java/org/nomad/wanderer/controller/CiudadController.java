package org.nomad.wanderer.controller;

import org.nomad.wanderer.model.puntuacionDTO.CiudadPuntuacionResponseDTO;
import org.nomad.wanderer.service.CiudadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ciudades")
public class CiudadController {

    @Autowired
    private CiudadServiceImpl service;

    @GetMapping("/{nombre}")
    public ResponseEntity<CiudadPuntuacionResponseDTO> getCiudadPuntuacionByNombre(@PathVariable("nombre") String nombre){
        CiudadPuntuacionResponseDTO ciudadPuntuacion  = service.obtenerPuntuacionCiudad(nombre);

        if (ciudadPuntuacion == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(ciudadPuntuacion, HttpStatus.OK);
        }

    }

}
