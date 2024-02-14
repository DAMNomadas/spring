package org.nomad.wanderer.repository;

import org.nomad.wanderer.model.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICiudadRepository extends JpaRepository<Ciudad, Integer> {

    Ciudad getCiudadByNombre(String nombre);
    List<Ciudad> getCiudadByUniversalHealthcare(Boolean isUniversal);

}
