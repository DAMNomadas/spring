package org.nomad.wanderer.service;

import org.nomad.wanderer.model.Ciudad;
import org.nomad.wanderer.model.PuntuacionUsuariosCiudad;
import org.nomad.wanderer.repository.ICiudadRepository;
import org.nomad.wanderer.repository.IPuntuacionCiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PuntuacionCiudadServiceImp implements IPuntuacionCiudadService{

    @Autowired
    public IPuntuacionCiudadRepository repo;

    @Autowired
    public ICiudadRepository repoCiudad;

    @Override
    public List<PuntuacionUsuariosCiudad> getPuntuacionesCiudad(String nombre) {

        Ciudad ciudad = repoCiudad.getCiudadByNombre(nombre);

        return repo.getPuntuacionUsuariosCiudadByCiudad(ciudad);

    }
}
