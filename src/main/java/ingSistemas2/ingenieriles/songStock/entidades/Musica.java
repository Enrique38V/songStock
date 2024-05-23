package ingSistemas2.ingenieriles.songStock.entidades;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "musica")
public class Musica {

    @Id
    @Column (name = "idmusica")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMusica;

    @Column (name = "nombre")
    private String nombre;

    @Column (name = "artista")
    private String artista;

    @Column (name = "genero")
    private String genero;

    @Column (name = "peso")
    private String peso;

    @Column (name = "precio")
    private BigDecimal precio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idvendedor")
    private Vendedor vendedor;


}
