package org.nomad.wanderer.model.dto.noticiasDTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nomad.wanderer.model.CategoriaNoticias;
import org.nomad.wanderer.model.Ciudad;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoticiaResponseDTO {

    private int idNoticia;

    private String titulo;

    private String texto;

    private byte[] imagen;

    private String nombre;

    private String categoria;
}
