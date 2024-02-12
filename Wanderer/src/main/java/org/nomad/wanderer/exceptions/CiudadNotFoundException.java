package org.nomad.wanderer.service;

public class CiudadNotFoundException extends RuntimeException {
    public CiudadNotFoundException(String laCiudadEspecificadaNoExiste) {
        super(laCiudadEspecificadaNoExiste);
    }
}
