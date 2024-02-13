package org.nomad.wanderer.service;

import org.nomad.wanderer.model.PuntuacionUsuariosCiudad;

import java.util.List;

public interface IPuntuacionCiudadService {
    List<PuntuacionUsuariosCiudad> getPuntuacionesCiudad(String nombre);
}
