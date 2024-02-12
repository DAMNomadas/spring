package org.nomad.wanderer.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticiaRequestDTO {

    @NotBlank
    private String titulo;

    @Size(min = 100, message = "La noticia debe tener al menos 100 caracteres")
    private String texto;

    //añadir imagen

    @NotBlank
    private String nombreCiutat;

    @NotBlank
    private String nombreCategoria;

}
