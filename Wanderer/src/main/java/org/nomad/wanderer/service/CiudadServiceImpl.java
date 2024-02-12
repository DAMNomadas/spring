package org.nomad.wanderer.service;

import org.nomad.wanderer.model.Ciudad;
import org.nomad.wanderer.repository.ICiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CiudadServiceImpl implements ICiudadService {

    @Autowired
    private ICiudadRepository repo;

    @Override
    public Ciudad getCiudadByNombre(String ciudad) {
        return repo.getCiudadByNombreCiudad(ciudad);
    }
}
