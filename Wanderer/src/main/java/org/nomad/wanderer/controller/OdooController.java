package org.nomad.wanderer.controller;

import org.nomad.wanderer.model.UsuarioOdoo;
import org.nomad.wanderer.model.UsuarioRegistroOdoo;
import org.nomad.wanderer.service.OdooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuariosOdoo")
public class OdooController {

    @Autowired
    private OdooService service;

    @PostMapping
    public Object login(@RequestBody UsuarioOdoo usuarioOdoo){
        Object obj = service.login(usuarioOdoo);

        return obj;

    }

    @PostMapping
    public Object registrar(@RequestBody UsuarioRegistroOdoo usuario){
        Object object = service.registrarUsuarioOdoo(usuario);

        return object;
    }




}
