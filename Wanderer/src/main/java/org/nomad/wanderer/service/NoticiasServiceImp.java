package org.nomad.wanderer.service;

import org.modelmapper.ModelMapper;
import org.nomad.wanderer.model.Noticias;
import org.nomad.wanderer.model.dto.NoticiaRequestDTO;
import org.nomad.wanderer.model.dto.NoticiaResponseDTO;
import org.nomad.wanderer.repository.INoticiasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoticiasServiceImp implements INoticasService{

    @Autowired
    public INoticiasRepository repo;

    @Service
    public

    @Autowired
    public ModelMapper modelMapper;

    @Override
    public List<NoticiaResponseDTO> getAllNoticas() {
        List<Noticias> list = repo.findAll();

        List<NoticiaResponseDTO> listaDTO = list.stream()
                .map(noticias -> modelMapper.map(noticias, NoticiaResponseDTO.class))
                .collect(Collectors.toList());
        return listaDTO;
    }

    @Override
    public List<NoticiaResponseDTO> getNoticiasByCiudad(String ciudad) {
        List<Noticias> list = repo.getNoticiasByCiudad(ciudad);

        List<NoticiaResponseDTO> listaDTO = list.stream()
                .map(noticias -> modelMapper.map(noticias, NoticiaResponseDTO.class))
                .collect(Collectors.toList());
        return listaDTO;
    }

    @Override
    public List<NoticiaResponseDTO> getNoticasByCategoria(String categoria) {
        List<Noticias> list = repo.getNoticiasByCategoria(categoria);

        List<NoticiaResponseDTO> listaDTO = list.stream()
                .map(noticias -> modelMapper.map(noticias, NoticiaResponseDTO.class))
                .collect(Collectors.toList());
        return listaDTO;
    }

    @Override
    public List<NoticiaResponseDTO> getNoticasByCategoriaAndCiudad(String categoria, String ciudad) {
        List<Noticias> list = repo.getNoticiasByCategoriaAndCiudad(categoria, ciudad);

        List<NoticiaResponseDTO> listaDTO = list.stream()
                .map(noticias -> modelMapper.map(noticias, NoticiaResponseDTO.class))
                .collect(Collectors.toList());
        return listaDTO;

    }

    @Override
    public Noticias addNoticia(NoticiaRequestDTO noticiaDTO) {
        return null;
    }

    @Override
    public void eliminarNotica(Integer id) {

    }
}
