package org.nomad.wanderer.service;

import org.nomad.wanderer.model.PuntuacionUsuariosCiudad;
import org.nomad.wanderer.model.puntuacionDTO.CiudadPuntuacionRequestDTO;
import org.nomad.wanderer.model.puntuacionDTO.PuntuacionCiudadUsuarioResponseDTO;

import java.util.List;

public interface IPuntuacionCiudadService {
    List<PuntuacionUsuariosCiudad> getPuntuacionesCiudad(String nombre);
    PuntuacionUsuariosCiudad addPuntuacionCiudad(CiudadPuntuacionRequestDTO puntuacion);

    PuntuacionCiudadUsuarioResponseDTO getPuntuacionCiudadUsuario(String nombre, int idUsuario);
}
