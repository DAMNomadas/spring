package org.nomad.wanderer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "info_cuidad")
public class InfoCiudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_info")
    private int idInfo;

    @Column(name = "texto")
    private String texto;

    @Column(name = "url_video")
    private String urlVideo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCiutat")
    private Ciudad ciudad;

}
