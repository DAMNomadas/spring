package org.nomad.wanderer.service;

import org.modelmapper.ModelMapper;
import org.nomad.wanderer.model.Ciudad;
import org.nomad.wanderer.model.PuntuacionUsuariosCiudad;
import org.nomad.wanderer.model.ciudadDTO.AddCiudadRequest;
import org.nomad.wanderer.model.puntuacionDTO.CiudadPuntuacionResponseDTO;
import org.nomad.wanderer.repository.ICiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        return repo.getCiudadByNombre(ciudad);
    }

    @Override
    public Ciudad addCiudad(AddCiudadRequest ciudadDTO) {

        Ciudad existeCiudad = repo.getCiudadByNombre(ciudadDTO.getNombre());

        if (existeCiudad == null){
            Ciudad ciudad = modelMapper.map(ciudadDTO, Ciudad.class);
            return repo.save(ciudad);
        }

        return null;
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
                listaDTO.add(dto);
            }

        }

        return listaDTO;

    }

    @Override
    public List<CiudadPuntuacionResponseDTO> getCiudadByHealthCare(Boolean isUniversal) {
        return null;
    }

    public CiudadPuntuacionResponseDTO obtenerPuntuacionCiudad(String nombre){

        Ciudad ciudad = repo.getCiudadByNombre(nombre);
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
