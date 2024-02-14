package org.nomad.wanderer.service;

import org.nomad.wanderer.model.Ciudad;
import org.nomad.wanderer.model.ciudadDTO.AddCiudadRequest;
import org.nomad.wanderer.model.ciudadDTO.UpdateCiudadRequest;
import org.nomad.wanderer.model.puntuacionDTO.CiudadPuntuacionResponseDTO;

import java.util.List;

public interface ICiudadService {

    Ciudad getCiudadByNombre(String ciudad);

    Ciudad addCiudad(AddCiudadRequest ciudad);

    List<CiudadPuntuacionResponseDTO> getAllPuntuaciones();

    Ciudad modificarCiudad(UpdateCiudadRequest ciudad);

}
