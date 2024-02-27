package org.nomad.wanderer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Noticias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_noticia")
    private int idNoticia;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "texto")
    private String texto;

    @Lob
    @Column(name = "imagen")
    private byte[] imagen;

    private transient MultipartFile imagenFile;

    @ManyToOne
    @JoinColumn(name = "idCiutat")
    private Ciudad ciudad;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private CategoriaNoticias categoria;

}
