package org.nomad.wanderer.controller;

import org.nomad.wanderer.model.PuntuacionUsuariosCiudad;
import org.nomad.wanderer.model.puntuacionDTO.CiudadPuntuacionRequestDTO;
import org.nomad.wanderer.model.puntuacionDTO.CiudadPuntuacionResponseDTO;
import org.nomad.wanderer.model.puntuacionDTO.PuntuacionCiudadUsuarioResponseDTO;
import org.nomad.wanderer.service.IPuntuacionCiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/puntuaciones")
public class PuntuacionCiudadController {

    @Autowired
    private IPuntuacionCiudadService service;

    @PostMapping
    public ResponseEntity<PuntuacionUsuariosCiudad> addPuntuacion(@RequestBody CiudadPuntuacionRequestDTO puntuacionRequestDTO){
        PuntuacionUsuariosCiudad obj = service.addPuntuacionCiudad(puntuacionRequestDTO);

        if (obj == null) {
            return new ResponseEntity<>(obj, HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(obj, HttpStatus.CREATED);
        }

    }

    @GetMapping("/filter")
    public ResponseEntity<PuntuacionCiudadUsuarioResponseDTO> getPuntuacionCiudadUsuario(@RequestParam(value = "ciudad")String ciudad,
                                                                                  @RequestParam(value = "idUsuario")int idUsuario){

        PuntuacionCiudadUsuarioResponseDTO obj = service.getPuntuacionCiudadUsuario(ciudad, idUsuario);

        if (obj == null) {
            return new ResponseEntity<>(obj, HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(obj, HttpStatus.OK);
        }

    }

}
