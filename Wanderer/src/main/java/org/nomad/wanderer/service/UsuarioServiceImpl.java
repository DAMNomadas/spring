package org.nomad.wanderer.service;

import org.nomad.wanderer.model.Usuario;
import org.nomad.wanderer.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    public IUsuarioRepository repo;

    @Override
    public Usuario getUsuarioById(int id) {
        return repo.getUsuarioById(id);
    }
}
