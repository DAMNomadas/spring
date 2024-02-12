package org.nomad.wanderer.repository;

import org.nomad.wanderer.model.Noticias;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoticiasRepository extends JpaRepository<Noticias, Integer> {

    List<Noticias> getNoticiasByCiudad(String ciudad);
    List<Noticias> getNoticiasByCategoria(String categoria);
    List<Noticias> getNoticiasByCategoriaAndCiudad(String categoria, String ciudad);

}
