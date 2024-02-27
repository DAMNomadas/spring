package org.nomad.wanderer.service;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.nomad.wanderer.exceptions.CategoriaNotFoundException;
import org.nomad.wanderer.exceptions.CiudadNotFoundException;
import org.nomad.wanderer.exceptions.NoticiasNotFoundException;
import org.nomad.wanderer.model.*;
import org.nomad.wanderer.model.ciudadDTO.AddCiudadRequest;
import org.nomad.wanderer.model.ciudadDTO.UpdateCiudadRequest;
import org.nomad.wanderer.model.dto.noticiasDTO.NoticiaRequestDTO;
import org.nomad.wanderer.model.puntuacionDTO.CiudadPuntuacionRequestDTO;
import org.nomad.wanderer.model.puntuacionDTO.CiudadPuntuacionResponseDTO;
import org.nomad.wanderer.repository.ICiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Transactional
@Service
public class CiudadServiceImpl implements ICiudadService {

    @Autowired
    private ICiudadRepository repo;

    @Autowired
    public IPuntuacionCiudadService servicePuntuaciones;

    @Autowired
    public ModelMapper modelMapper;

    @Override
    public Ciudad getCiudadByNombre(String ciudad) {
        System.out.println("Nombre de ciudad:"+ciudad);
        return repo.getCiudadByNombreIgnoreCase(ciudad);
    }

//    @Override
//    public Ciudad addCiudad(AddCiudadRequest ciudadDTO) {
//
//        Ciudad existeCiudad = repo.getCiudadByNombre(ciudadDTO.getNombre());
//
//        if (existeCiudad == null){
//            Ciudad ciudad = modelMapper.map(ciudadDTO, Ciudad.class);
//            return repo.save(ciudad);
//        }
//
//        return null;
//    }

    @Override
    public Ciudad addCiudad(AddCiudadRequest ciudadDTO) {
        Ciudad existeCiudad = repo.getCiudadByNombreIgnoreCase(ciudadDTO.getNombre());

        if (existeCiudad == null){
            Ciudad ciudad = modelMapper.map(ciudadDTO, Ciudad.class);

            MultipartFile imagenFile = ciudadDTO.getImagenFile();
            if (imagenFile != null && !imagenFile.isEmpty()) {
                try {
                    ciudad.setImagen(imagenFile.getBytes());
                } catch (IOException e) {
                    throw new RuntimeException("Error al cargar la imagen");
                }
            }
            repo.save(ciudad);

            CiudadPuntuacionRequestDTO puntuacion = new CiudadPuntuacionRequestDTO();
            puntuacion.setNombre(ciudadDTO.getNombre());
            puntuacion.setId(2);
            puntuacion.setLgtbiqFriendlyMedia(9);
            puntuacion.setPetFriendlyMedia(8);
            puntuacion.setSportsLifeMedia(4);
            puntuacion.setSafetyRateMedia(7);
            puntuacion.setClimateQualityMedia(3);
            puntuacion.setFemaleFriendlyMedia(8);
            puntuacion.setInternetQualityMedia(4);
            puntuacion.setCostLifeMedia(3);
            servicePuntuaciones.addPuntuacionCiudad(puntuacion);


        }
        return null;
    }
    @Override
    public Ciudad getCiudadById(int id) {
        Optional<Ciudad> optionalCiudad = repo.findByIdCiutat(id);
        return optionalCiudad.orElseThrow(() -> new NoticiasNotFoundException("Ciudad no encontrada con el ID: " + id));
    }
    @Override
    public List<CiudadPuntuacionResponseDTO> getAllPuntuaciones(){

        List<Ciudad> ciudadList = repo.findAll();
        List<CiudadPuntuacionResponseDTO> listaDTO = new ArrayList<>();

        for(Ciudad c: ciudadList){
            List<PuntuacionUsuariosCiudad> puntuaciones = servicePuntuaciones.getPuntuacionesCiudad(c.getNombre());

            if (!puntuaciones.isEmpty()){
                int lgtbiqFriendlyMedia = calcularMedia(puntuaciones, "lgtbiqFriendly");
                int petFriendlyMedia = calcularMedia(puntuaciones,"petFriendly");
                int sportsLifeMedia = calcularMedia(puntuaciones,"sportsLife");
                int safetyRateMedia = calcularMedia(puntuaciones,"safetyRate");
                int climateQualityMedia = calcularMedia(puntuaciones,"climateQuality");
                int femaleFriendlyMedia = calcularMedia(puntuaciones,"femaleFriendly");
                int internetQualityMedia = calcularMedia(puntuaciones,"internetQuality");
                int costLifeMedia = calcularMedia(puntuaciones,"costLife");

                CiudadPuntuacionResponseDTO dto = new CiudadPuntuacionResponseDTO();
                modelMapper.map(c, dto);
                // Aquí asigna las medias de puntuación a los campos correspondientes del DTO
                dto.setLgtbiqFriendlyMedia(lgtbiqFriendlyMedia);
                dto.setPetFriendlyMedia(petFriendlyMedia);
                dto.setSportsLifeMedia(sportsLifeMedia);
                dto.setSafetyRateMedia(safetyRateMedia);
                dto.setClimateQualityMedia(climateQualityMedia);
                dto.setFemaleFriendlyMedia(femaleFriendlyMedia);
                dto.setInternetQualityMedia(internetQualityMedia);
                dto.setCostLifeMedia(costLifeMedia);
                dto.setImagenUrl("/ciudades/imagen/" + c.getIdCiutat());
                listaDTO.add(dto);
            }

        }

        return listaDTO;

    }

    @Override
    public Ciudad modificarCiudad(UpdateCiudadRequest ciudad) {

        Optional<Ciudad> ciudadOptional = repo.findById(ciudad.getIdCiutat());
        System.out.println("EL id de la ciudad es: "+ciudad.getIdCiutat());
        if (ciudadOptional.isPresent()) {
            Ciudad ciudadActual = ciudadOptional.get();
            ciudadActual.setDescripcion(ciudad.getDescripcion());
            ciudadActual.setImagen(ciudad.getImagen());
            ciudadActual.setUniversalHealthcare(ciudad.isUniversalHealthcare());
            ciudadActual.setAverageSalary(ciudad.getAverageSalary());

            return repo.save(ciudadActual);

        }else {
            throw new CiudadNotFoundException("La ciudad especificada no existe");
        }

    }

    public CiudadPuntuacionResponseDTO obtenerPuntuacionCiudad(String nombre){

        Ciudad ciudad = repo.getCiudadByNombreIgnoreCase(nombre);
        List<PuntuacionUsuariosCiudad> puntuaciones = servicePuntuaciones.getPuntuacionesCiudad(nombre);

        // Calculamos las medias de las puntuaciones
        int lgtbiqFriendlyMedia = calcularMedia(puntuaciones, "lgtbiqFriendly");
        int petFriendlyMedia = calcularMedia(puntuaciones,"petFriendly");
        int sportsLifeMedia = calcularMedia(puntuaciones,"sportsLife");
        int safetyRateMedia = calcularMedia(puntuaciones,"safetyRate");
        int climateQualityMedia = calcularMedia(puntuaciones,"climateQuality");
        int femaleFriendlyMedia = calcularMedia(puntuaciones,"femaleFriendly");
        int internetQualityMedia = calcularMedia(puntuaciones,"internetQuality");
        int costLifeMedia = calcularMedia(puntuaciones,"costLife");

        // Creamos un nuevo DTO y mapeamos los campos de la entidad y las medias de puntuación
        CiudadPuntuacionResponseDTO dto = new CiudadPuntuacionResponseDTO();
        modelMapper.map(ciudad, dto);
        // Aquí asigna las medias de puntuación a los campos correspondientes del DTO
        dto.setLgtbiqFriendlyMedia(lgtbiqFriendlyMedia);
        dto.setPetFriendlyMedia(petFriendlyMedia);
        dto.setSportsLifeMedia(sportsLifeMedia);
        dto.setSafetyRateMedia(safetyRateMedia);
        dto.setClimateQualityMedia(climateQualityMedia);
        dto.setFemaleFriendlyMedia(femaleFriendlyMedia);
        dto.setInternetQualityMedia(internetQualityMedia);
        dto.setCostLifeMedia(costLifeMedia);

        return dto;
    }

    private int calcularMedia(List<PuntuacionUsuariosCiudad> puntuaciones, String attributeName) {
        int sum = 0;
        for (PuntuacionUsuariosCiudad puntuacion : puntuaciones) {
            switch (attributeName) {
                case "lgtbiqFriendly":
                    sum += puntuacion.getLgtbiqFriendly();
                    break;
                case "petFriendly":
                    sum += puntuacion.getPetFriendly();
                    break;
                case "sportsLife":
                    sum += puntuacion.getSportsLife();
                    break;
                case "safetyRate":
                    sum += puntuacion.getSafetyRate();
                    break;
                case "climateQuality":
                    sum += puntuacion.getClimateQuality();
                    break;
                case "femaleFriendly":
                    sum += puntuacion.getFemaleFriendly();
                    break;
                case "internetQuality":
                    sum += puntuacion.getInternetQuality();
                    break;
                case "costLife":
                    sum += puntuacion.getCostLife();
                    break;
                // Agrega más casos para los otros atributos de puntuación
                default:
                    throw new IllegalArgumentException("Atributo de puntuación no válido: " + attributeName);
            }
        }
        return sum / puntuaciones.size();
    }

}
