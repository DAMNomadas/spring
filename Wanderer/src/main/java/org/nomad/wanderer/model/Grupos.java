package org.nomad.wanderer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grupos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGrupo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCiutat")
    private Ciudad ciudad;



}
