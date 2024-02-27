package org.nomad.wanderer.repository;

import org.nomad.wanderer.model.Ciudad;
import org.nomad.wanderer.model.Noticias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICiudadRepository extends JpaRepository<Ciudad, Integer> {

    Ciudad getCiudadByNombreIgnoreCase(String nombre);
    List<Ciudad> getCiudadByUniversalHealthcare(Boolean isUniversal);
    Optional<Ciudad> findByIdCiutat(int id);

}
