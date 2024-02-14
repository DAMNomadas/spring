package org.nomad.wanderer.model.puntuacionDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PuntuacionCiudadUsuarioResponseDTO {

    /*Ciudad*/
    private String nombre;


    /*PuntuacionUsuariosCiudad*/
    private float lgtbiqFriendly;
    private float petFriendly;
    private float sportsLife;
    private float safetyRate;
    private float climateQuality;
    private float femaleFriendly;
    private float internetQuality;
    private float costLife;

}
