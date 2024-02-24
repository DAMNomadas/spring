package org.nomad.wanderer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(name = "imagen")
    //private byte[] imagen;
    private String urlImagen;

    @Column(name = "pais")
    private String pais;

    @Column(name = "longuitud")
    private double longuitud;

    @Column(name = "latitud")
    private double latitud;

    @Column(name = "url_video")
    private String urlVideo;



    /*@Column
    private byte[] video;*/

}
