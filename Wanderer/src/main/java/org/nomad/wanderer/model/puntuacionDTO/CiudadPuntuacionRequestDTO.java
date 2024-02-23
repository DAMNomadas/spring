package org.nomad.wanderer.model.puntuacionDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CiudadPuntuacionRequestDTO {

    /*Ciudad*/
    private String nombre;


    /*PuntuacionUsuariosCiudad*/
    private float lgtbiqFriendlyMedia;
    private float petFriendlyMedia;
    private float sportsLifeMedia;
    private float safetyRateMedia;
    private float climateQualityMedia;
    private float femaleFriendlyMedia;
    private float internetQualityMedia;
    private float costLifeMedia;
    private int idUserOdoo;

}
