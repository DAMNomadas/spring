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
    @Column
    private int idCiutat;

    @Column
    private String nombre;

    @Column(name = "lgtbiq_friendly")
    private int lgtbiqFriendly;

    @Column(name = "pet_friendly")
    private int petFriendly;

    @Column(name = "sports_life")
    private int sportsLife;

    @Column(name = "armed_conflicts")
    private boolean armedConflicts;

    @Column(name = "universal_healthcare")
    private boolean universalHealthcare;

    @Column(name = "climate_quality")
    private int climateQuality;

    @Column(name = "female_friendly")
    private int femaleFriendly;

    @Column(name = "internet_quality")
    private int internetQuality;

    @Column(name = "cost_life")
    private float costLife;

    @Column(name = "puntuacion_nomada")
    private float puntuacionNomada;

    @Column(name = "region")
    private String region;

    @Column(name = "pais")
    private String pais;
}
