package org.nomad.wanderer.service;

import org.nomad.wanderer.model.CategoriaNoticias;
import org.nomad.wanderer.repository.ICategoriaNoticiasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaNoticiasServiceImp implements ICategoriaNoticasService{

    @Autowired
    private ICategoriaNoticiasRepository repo;

    @Override
    public List<CategoriaNoticias> getAll() {
        return repo.findAll();
    }

    @Override
    public CategoriaNoticias getCategoriaNoticiasByCategoria(String categoria) {
        return repo.getCategoriaNoticiasByCategoria(categoria);
    }

    @Override
    public CategoriaNoticias getCategoriaNoticiasByIdCategoria(Integer idCategoria) {
        return repo.getCategoriaNoticiasByIdCategoria(idCategoria);
    }
}
