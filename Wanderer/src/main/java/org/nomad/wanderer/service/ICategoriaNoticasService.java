package org.nomad.wanderer.service;

import org.nomad.wanderer.model.CategoriaNoticias;

import java.util.List;

public interface ICategoriaNoticasService {

    List<CategoriaNoticias> getAll();
    CategoriaNoticias getCategoriaNoticiasByCategoria(String categoria);
    CategoriaNoticias getCategoriaNoticiasByIdCategoria(Integer idCategoria);

}
