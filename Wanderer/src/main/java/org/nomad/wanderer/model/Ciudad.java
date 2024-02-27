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
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCiutat;

    @Column
    private String nombre;

    @Column
    private String descripcion;

    @Column(name = "universal_healthcare")//este no va en la tabla de votaciones
    private boolean universalHealthcare;

    @Column
    private float averageSalary;

    @Lob
    @Column(name = "imagen")
    private byte[] imagen;

    private transient MultipartFile imagenFile;

    @Column(name = "pais")
    private String pais;

    @Column(name = "video")
    private String video;

    @Column(name = "latitud")
    private float latitud;

    @Column(name = "longitud")
    private float longitud;
}
