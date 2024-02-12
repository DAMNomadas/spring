package org.nomad.wanderer.service;

import org.nomad.wanderer.model.Noticias;
import org.nomad.wanderer.model.dto.NoticiaRequestDTO;
import org.nomad.wanderer.model.dto.NoticiaResponseDTO;

import java.util.List;

public interface INoticasService {
    List<NoticiaResponseDTO> getAllNoticas();
    List<NoticiaResponseDTO> getNoticiasByCiudad(String ciudad);
    List<NoticiaResponseDTO> getNoticasByCategoria(String categoria);
    List<NoticiaResponseDTO> getNoticasByCategoriaAndCiudad(String categoria, String ciudad);
    Noticias addNoticia (NoticiaRequestDTO noticiaDTO);
    void eliminarNotica(Integer id);


}
