package org.nomad.wanderer.service;

import org.modelmapper.ModelMapper;
import org.nomad.wanderer.exceptions.CiudadNotFoundException;
import org.nomad.wanderer.exceptions.PuntuacionUsuarioNotFoundException;
import org.nomad.wanderer.exceptions.UsuarioNotFoundException;
import org.nomad.wanderer.model.Ciudad;
import org.nomad.wanderer.model.PuntuacionUsuariosCiudad;
import org.nomad.wanderer.model.Usuario;
import org.nomad.wanderer.model.puntuacionDTO.CiudadPuntuacionRequestDTO;
import org.nomad.wanderer.model.puntuacionDTO.PuntuacionCiudadUsuarioResponseDTO;
import org.nomad.wanderer.repository.ICiudadRepository;
import org.nomad.wanderer.repository.IPuntuacionCiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PuntuacionCiudadServiceImp implements IPuntuacionCiudadService{

    @Autowired
    public IPuntuacionCiudadRepository repo;

    @Autowired
    public ICiudadRepository repoCiudad;

    @Autowired
    public IUsuarioService usuarioService;

    @Autowired
    public ModelMapper modelMapper;

    @Override
    public List<PuntuacionUsuariosCiudad> getPuntuacionesCiudad(String nombre) {

        Ciudad ciudad = repoCiudad.getCiudadByNombre(nombre);

        return repo.getPuntuacionUsuariosCiudadByCiudad(ciudad);

    }

    @Override
    public PuntuacionUsuariosCiudad addPuntuacionCiudad(CiudadPuntuacionRequestDTO puntuacionDTO) {

        String nombreCiudad = puntuacionDTO.getNombre();
        Ciudad ciudad = repoCiudad.getCiudadByNombre(nombreCiudad);

        if (ciudad == null) {
            throw new CiudadNotFoundException("La ciudad especificada no existe");
        }

        Usuario usuario = usuarioService.getUsuarioById(puntuacionDTO.getId());

        if (usuario == null) {
            throw new UsuarioNotFoundException("El usuario no existe");
        }

        PuntuacionUsuariosCiudad puntuacion = modelMapper.map(puntuacionDTO, PuntuacionUsuariosCiudad.class);
        puntuacion.setCiudad(ciudad);
        puntuacion.setUsuario(usuario);

        return repo.save(puntuacion);

    }

    @Override
    public PuntuacionCiudadUsuarioResponseDTO getPuntuacionCiudadUsuario(String nombre, int idUsuario) {

        Ciudad ciudad = repoCiudad.getCiudadByNombre(nombre);

        if (ciudad == null) {
            throw new CiudadNotFoundException("La ciudad especificada no existe");
        }

        Usuario usuario = usuarioService.getUsuarioById(idUsuario);

        if (usuario == null) {
            throw new UsuarioNotFoundException("El usuario no existe");
        }

        PuntuacionUsuariosCiudad ciudadPuntuada = repo.getPuntuacionUsuariosCiudadByUsuarioAndCiudad(usuario, ciudad);

        if (ciudadPuntuada == null) {
            throw new PuntuacionUsuarioNotFoundException("El usuario no ha votado la ciudad");
        }

        PuntuacionCiudadUsuarioResponseDTO puntuacioDTO = modelMapper.map(ciudadPuntuada, PuntuacionCiudadUsuarioResponseDTO.class);

        return puntuacioDTO;

    }
}
