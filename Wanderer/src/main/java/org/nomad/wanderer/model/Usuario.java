package org.nomad.wanderer.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    private int id;

    @Column
    private float latitud;
    @Column
    private float longuitud;
    @Column
    private String diet;
    @Column
    private String originCountry;
    @Column
    private String sexualInterest;
    @Column
    private String estudios;
    @Column
    private String job;
    @Column
    private String sports;
    @Column
    private String religion;
    @Column
    private String name;
    @Column
    private String lastname;
    @Column
    private int karmaLeve;

}
