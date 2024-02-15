package org.nomad.wanderer.model.puntuacionDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CiudadPuntuacionResponseDTO {

    /*Ciudad*/
    private int idCiutat;
    private String nombre;
    private String descripcion;
    private boolean universalHealthcare;
    private float averageSalary;
    private byte[] imagen;
    private String pais;

    /*PuntuacionUsuariosCiudad*/
    private float lgtbiqFriendlyMedia;
    private float petFriendlyMedia;
    private float sportsLifeMedia;
    private float safetyRateMedia;
    private float climateQualityMedia;
    private float femaleFriendlyMedia;
    private float internetQualityMedia;
    private float costLifeMedia;

}
