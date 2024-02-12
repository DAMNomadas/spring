package org.nomad.wanderer.service;

import org.modelmapper.ModelMapper;
import org.nomad.wanderer.model.CategoriaNoticias;
import org.nomad.wanderer.model.Ciudad;
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

    @Autowired
    public ICategoriaNoticasService serviceCategoria;

    @Autowired
    public ICiudadService serviceCiudad;

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

        // Validar que la categoría existe
        CategoriaNoticias categoria = serviceCategoria.getCategoriaNoticiasByCategoria(noticiaDTO.getNombreCategoria());
        if (categoria == null) {
            throw new CategoriaNotFoundException("La categoría especificada no existe");
        }

        // Validar que la ciudad existe
        Ciudad ciudad = serviceCiudad.getCiudadByNombre(noticiaDTO.getNombreCiutat());
        if (ciudad == null) {
            throw new CiudadNotFoundException("La ciudad especificada no existe");
        }

        // Mapear DTO a entidad
        Noticias noticia = modelMapper.map(noticiaDTO, Noticias.class);

        // Asignar la categoría y la ciudad a la noticia
        noticia.setCategoria(categoria);
        noticia.setCiudad(ciudad);

        // Guardar la noticia en la base de datos
        return repo.save(noticia);
    }

    @Override
    public void eliminarNotica(Integer id) {

        repo.deleteById(id);

    }
}
