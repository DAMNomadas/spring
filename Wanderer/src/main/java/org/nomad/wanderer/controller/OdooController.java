package org.nomad.wanderer.controller;

import org.nomad.wanderer.model.UsuarioOdoo;
import org.nomad.wanderer.service.OdooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuariosOdoo")
public class OdooController {

    @Autowired
    private OdooService service;

    @GetMapping
    public Object login(@RequestBody UsuarioOdoo usuarioOdoo){
        Object obj = service.login(usuarioOdoo);

        return obj;

    }




}
