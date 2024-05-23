package ingSistemas2.ingenieriles.songStock.entidades;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "vinilo")
public class Vinilo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvinilo")
    private Integer idVinilo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "artista")
    private String artista;

    @Column(name = "genero")
    private String genero;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "precio")
    private BigDecimal precio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idvendedor")
    private Vendedor vendedor;

}
