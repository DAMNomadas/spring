package org.nomad.wanderer.repository;

import org.nomad.wanderer.model.CategoriaNoticias;
import org.nomad.wanderer.model.Ciudad;
import org.nomad.wanderer.model.Noticias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface INoticiasRepository extends JpaRepository<Noticias, Integer> {

    List<Noticias> getNoticiasByCiudad(Ciudad ciudad);
    List<Noticias> getNoticiasByCategoria(CategoriaNoticias categoria);
    List<Noticias> getNoticiasByCategoriaAndCiudad(CategoriaNoticias categoria, Ciudad ciudad);

}
