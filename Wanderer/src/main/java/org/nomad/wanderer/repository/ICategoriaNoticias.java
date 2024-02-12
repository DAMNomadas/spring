package org.nomad.wanderer.repository;

import org.nomad.wanderer.model.CategoriaNoticias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriaNoticias extends JpaRepository<CategoriaNoticias, Integer> {

    CategoriaNoticias getCategoriaNoticiasByCategoria(String categoria);
    CategoriaNoticias getCategoriaNoticiasByIdCategoria(Integer idCategoria);

}
