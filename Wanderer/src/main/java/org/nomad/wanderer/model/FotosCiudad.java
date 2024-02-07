package org.nomad.wanderer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FotosCiudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_foto")
    private int idFoto;

    @Lob
    @Column(name = "foto")
    private byte[] foto;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCiutat")
    private Ciudad ciudad;

    @Column(name = "id_usuario")
    private int idUsuario;

}
