package org.nomad.wanderer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PuntuacionUsuariosCiudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPuntuacion;

    @Column(name = "lgtbiq_friendly")
    private int lgtbiqFriendly;

    @Column(name = "pet_friendly")
    private int petFriendly;

    @Column(name = "sports_life")
    private int sportsLife;

    @Column(name = "safety_rate")
    private int safetyRate;

    @Column(name = "climate_quality")
    private int climateQuality;

    @Column(name = "female_friendly")
    private int femaleFriendly;

    @Column(name = "internet_quality")
    private int internetQuality;

    @Column(name = "cost_life")
    private int costLife;

    /*@ManyToOne
    @JoinColumn(name = "id")*/
    @Column(name = "user_odoo")
    private int userOdoo;

    @ManyToOne
    @JoinColumn(name = "idCiutat")
    private Ciudad ciudad;

}
