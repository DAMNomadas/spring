package org.nomad.wanderer.controller;

import org.nomad.wanderer.model.CategoriaNoticias;
import org.nomad.wanderer.service.CategoriaNoticiasServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaNoticiasController {

    @Autowired
    private CategoriaNoticiasServiceImp service;

    @GetMapping
    private ResponseEntity<List<CategoriaNoticias>> getAllCategorias(){
        List<CategoriaNoticias> list = service.getAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(list, HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }
}
