package org.nomad.wanderer.service;

import org.nomad.wanderer.model.Noticias;
import org.nomad.wanderer.model.dto.noticiasDTO.NoticiaRequestDTO;
import org.nomad.wanderer.model.dto.noticiasDTO.NoticiaResponseDTO;

import java.util.List;

public interface INoticasService {
    List<NoticiaResponseDTO> getAllNoticias();
    List<NoticiaResponseDTO> getNoticiasByCiudad(String ciudad);
    List<NoticiaResponseDTO> getNoticasByCategoria(String categoria);
    List<NoticiaResponseDTO> getNoticasByCategoriaAndCiudad(String categoria, String ciudad);
    Noticias addNoticia (NoticiaRequestDTO noticiaDTO);
    void eliminarNotica(Integer id);


}
