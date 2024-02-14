package org.nomad.wanderer.repository;

import org.nomad.wanderer.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario getUsuarioById(int id);

}
