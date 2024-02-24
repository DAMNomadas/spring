package org.nomad.wanderer.model.ciudadDTO;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCiudadRequest {

    int idCiutat;
    @Size(min = 10, message = "La descripcion debe tener al menos 10 caracteres")
    private String descripcion;
    private boolean universalHealthcare;
    private float averageSalary;
    //private byte[] imagen;
    private String urlImagen;
    private String urlVideo;

}

