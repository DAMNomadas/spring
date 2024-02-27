package org.nomad.wanderer.service;

import org.modelmapper.ModelMapper;
import org.nomad.wanderer.exceptions.CategoriaNotFoundException;
import org.nomad.wanderer.exceptions.CiudadNotFoundException;
import org.nomad.wanderer.exceptions.NoticiasNotFoundException;
import org.nomad.wanderer.model.CategoriaNoticias;
import org.nomad.wanderer.model.Ciudad;
import org.nomad.wanderer.model.Noticias;
import org.nomad.wanderer.model.dto.noticiasDTO.NoticiaRequestDTO;
import org.nomad.wanderer.model.dto.noticiasDTO.NoticiaResponseDTO;
import org.nomad.wanderer.repository.INoticiasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
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
    public List<NoticiaResponseDTO> getAllNoticias() {
        List<Noticias> list = repo.findAll();

        return getNoticiaResponseDTOS(list);
    }

    @Override
    public List<NoticiaResponseDTO> getNoticiasByCiudad(String ciudad) {

        Ciudad ciudadEncontrada = serviceCiudad.getCiudadByNombre(ciudad);

        List<Noticias> list = repo.getNoticiasByCiudad(ciudadEncontrada);

        if (list.isEmpty()) {
            throw new NoticiasNotFoundException("No se encontraron noticias de la ciudad " + ciudad + " .");
        }

        return getNoticiaResponseDTOS(list);
    }



    @Override
    public List<NoticiaResponseDTO> getNoticasByCategoria(String categoria) {

        CategoriaNoticias categoriaEncontrada = serviceCategoria.getCategoriaNoticiasByCategoria(categoria);

        List<Noticias> list = repo.getNoticiasByCategoria(categoriaEncontrada);

        if (list.isEmpty()) {
            throw new NoticiasNotFoundException("No se encontraron noticias para la categoría " + categoria + " .");
        }

        return getNoticiaResponseDTOS(list);
    }

    @Override
    public List<NoticiaResponseDTO> getNoticasByCategoriaAndCiudad(String categoria, String ciudad) {

        CategoriaNoticias categoriaEncontrada = serviceCategoria.getCategoriaNoticiasByCategoria(categoria);
        Ciudad ciudadEncontrada = serviceCiudad.getCiudadByNombre(ciudad);

        List<Noticias> list = repo.getNoticiasByCategoriaAndCiudad(categoriaEncontrada, ciudadEncontrada);

        if (list.isEmpty()) {
            throw new NoticiasNotFoundException("No se encontraron noticias para la categoría " + categoria + " y la ciudad " + ciudad);
        }


        return getNoticiaResponseDTOS(list);

    }

//    @Override
//    public Noticias addNoticia(NoticiaRequestDTO noticiaDTO) {
//
//        // Validar que la categoría existe
//        CategoriaNoticias categoria = serviceCategoria.getCategoriaNoticiasByCategoria(noticiaDTO.getCategoria());
//        if (categoria == null) {
//            throw new CategoriaNotFoundException("La categoría especificada no existe");
//        }
//
//        // Validar que la ciudad existe
//        Ciudad ciudad = serviceCiudad.getCiudadByNombre(noticiaDTO.getNombre());
//        if (ciudad == null) {
//            throw new CiudadNotFoundException("La ciudad especificada no existe");
//        }
//
//        // Mapear DTO a entidad
//        Noticias noticia = modelMapper.map(noticiaDTO, Noticias.class);
//
//        // Asignar la categoría y la ciudad a la noticia
//        noticia.setCategoria(categoria);
//        noticia.setCiudad(ciudad);
//
//        // Guardar la noticia en la base de datos
//        return repo.save(noticia);
//    }

    @Override
    public Noticias addNoticia(NoticiaRequestDTO noticiaDTO) {

        // Validar que la categoría existe
        CategoriaNoticias categoria = serviceCategoria.getCategoriaNoticiasByCategoria(noticiaDTO.getCategoria());
        if (categoria == null) {
            throw new CategoriaNotFoundException("La categoría especificada no existe");
        }
        System.out.println("La ciudad DTO es: "+noticiaDTO.getNombre());
        // Validar que la ciudad existe
        Ciudad ciudad = serviceCiudad.getCiudadByNombre(noticiaDTO.getNombre());
        if (ciudad == null) {
            throw new CiudadNotFoundException("La ciudad especificada no existe");
        }

        // Mapear DTO a entidad
        Noticias noticia = modelMapper.map(noticiaDTO, Noticias.class);

        // Subir imagen
        MultipartFile imagenFile = noticiaDTO.getImagenFile();
        if (imagenFile != null && !imagenFile.isEmpty()) {
            try {
                noticia.setImagen(imagenFile.getBytes());
            } catch (IOException e) {
                // Manejar la excepción apropiadamente
                throw new RuntimeException("Error al cargar la imagen");
            }
        }

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

    /*PARA MAPEAR*/
//    private List<NoticiaResponseDTO> getNoticiaResponseDTOS(List<Noticias> list) {
//        List<NoticiaResponseDTO> listaDTO = list.stream()
//                .map(noticias -> {
//                    NoticiaResponseDTO dto = modelMapper.map(noticias, NoticiaResponseDTO.class);
//                    if (noticias.getCiudad() != null) {
//                        dto.setNombre(noticias.getCiudad().getNombre());
//                    }
//                    return dto;
//                })
//                .collect(Collectors.toList());
//        return listaDTO;
//    }

    private List<NoticiaResponseDTO> getNoticiaResponseDTOS(List<Noticias> list) {
        List<NoticiaResponseDTO> listaDTO = list.stream()
                .map(noticias -> {
                    NoticiaResponseDTO dto = modelMapper.map(noticias, NoticiaResponseDTO.class);
                    if (noticias.getCiudad() != null) {
                        dto.setNombre(noticias.getCiudad().getNombre());
                    }
                    // Crear URL de la imagen
                    dto.setImagenUrl("/noticias/imagen/" + noticias.getIdNoticia()); // Asumiendo una ruta apropiada para acceder a la imagen
                    return dto;
                })
                .collect(Collectors.toList());
        return listaDTO;
    }

    @Override
    public Noticias getNoticiaById(int id) {
        Optional<Noticias> optionalNoticia = repo.findByIdNoticia(id);
        return optionalNoticia.orElseThrow(() -> new NoticiasNotFoundException("Noticia no encontrada con el ID: " + id));
    }
}
