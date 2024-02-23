package org.nomad.wanderer.model.ciudadDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCiudadRequest {

    @NotBlank
    private String nombre;

    @Size(min = 10, message = "La descripcion debe tener al menos 10 caracteres")
    private String descripcion;

    private boolean universalHealthcare;

    private float averageSalary;
    //private byte[] imagen;
    @NotBlank
    private String pais;

    private String urlImagen;

    private double longuitud;

    private double latitud;

}
