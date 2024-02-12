package org.nomad.wanderer.service;

public class CategoriaNotFoundException extends RuntimeException  {
    public CategoriaNotFoundException(String laCategoríaEspecificadaNoExiste) {
        super(laCategoríaEspecificadaNoExiste);
    }
}
