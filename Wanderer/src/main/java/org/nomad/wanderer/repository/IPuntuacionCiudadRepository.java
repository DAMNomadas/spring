package org.nomad.wanderer.repository;

import org.nomad.wanderer.model.Ciudad;
import org.nomad.wanderer.model.PuntuacionUsuariosCiudad;
import org.nomad.wanderer.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPuntuacionCiudadRepository extends JpaRepository<PuntuacionUsuariosCiudad, Integer> {

    /*@Query("SELECT AVG(p.lgtbiqFriendly) FROM PuntuacionUsuariosCiudad p WHERE p.ciudad.idCiudad = :idCiudad")
    Float findLgtbiqFriendlyAverageByCiudadId(@Param("idCiudad") int idCiudad);*/

    List<PuntuacionUsuariosCiudad> getPuntuacionUsuariosCiudadByCiudad(Ciudad nombre);

    PuntuacionUsuariosCiudad getPuntuacionUsuariosCiudadByUsuarioAndCiudad(Usuario usuario, Ciudad nombre);

}
