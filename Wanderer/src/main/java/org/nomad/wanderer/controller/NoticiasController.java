package org.nomad.wanderer.controller;

import jakarta.validation.Valid;
import org.nomad.wanderer.model.Noticias;
import org.nomad.wanderer.model.dto.noticiasDTO.NoticiaRequestDTO;
import org.nomad.wanderer.model.dto.noticiasDTO.NoticiaResponseDTO;
import org.nomad.wanderer.service.INoticasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/noticias")
public class NoticiasController {

    @Autowired
    private INoticasService service;

    @GetMapping
    public ResponseEntity<List<NoticiaResponseDTO>> getAllNoticias(){
        List<NoticiaResponseDTO> lista = service.getAllNoticias();

        if (lista.isEmpty()) {
            return new ResponseEntity<>(lista, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }
    }

    @GetMapping("/ciudad/{nombre}")
    public ResponseEntity<List<NoticiaResponseDTO>> getNoticiasByCiudad(@PathVariable("nombre") String ciudad){

        List<NoticiaResponseDTO> lista = service.getNoticiasByCiudad(ciudad);

        if (lista.isEmpty()) {
            return new ResponseEntity<>(lista, HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<NoticiaResponseDTO>> getNoticiasByCategoria(@PathVariable("categoria") String categoria){
        List<NoticiaResponseDTO> lista = service.getNoticasByCategoria(categoria);

        if (lista.isEmpty()) {
            return new ResponseEntity<>(lista, HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }

    }
    @GetMapping("/filter")
    public ResponseEntity<List<NoticiaResponseDTO>> getNoticiasByCategoriaAndCiudad(@RequestParam(value = "categoria") String categoria,
                                                                                    @RequestParam(value = "ciudad")String ciudad){
        List<NoticiaResponseDTO> lista = service.getNoticasByCategoriaAndCiudad(categoria, ciudad);

        if (lista.isEmpty()) {
            return new ResponseEntity<>(lista, HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Noticias> addNoticia(@Valid @RequestBody NoticiaRequestDTO noticiaRequestDTO){

        Noticias obj = service.addNoticia(noticiaRequestDTO);

        if (obj == null) {
            return new ResponseEntity<>(obj, HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(obj, HttpStatus.CREATED);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarNoticia(@PathVariable(value = "id")Integer id){
        service.eliminarNotica(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
