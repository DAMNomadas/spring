package org.nomad.wanderer.model.dto.noticiasDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticiaRequestDTO {

    @NotBlank
    private String titulo;

    @Size(min = 10, message = "La noticia debe tener al menos 100 caracteres")
    private String texto;

    private MultipartFile imagenFile;

    @NotBlank
    private String nombre;

    @NotBlank
    private String categoria;

}
