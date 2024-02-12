package org.nomad.wanderer.exceptions;

public class CiudadNotFoundException extends RuntimeException {
    public CiudadNotFoundException(String laCiudadEspecificadaNoExiste) {
        super(laCiudadEspecificadaNoExiste);
    }
}
