package org.nomad.wanderer.model.ciudadDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCiudadRequest {

    @NotBlank
    private String nombre;

    @Size(min = 100, message = "La descripcion debe tener al menos 100 caracteres")

    private String descripcion;

    private boolean universalHealthcare;

    private float averageSalary;

    @NotBlank
    private String pais;

    private MultipartFile imagenFile;

    private String video;

    private float latitud;

    private float longitud;

}
