package org.nomad.wanderer.exceptions;

public class CategoriaNotFoundException extends RuntimeException  {
    public CategoriaNotFoundException(String laCategoríaEspecificadaNoExiste) {
        super(laCategoríaEspecificadaNoExiste);
    }
}
