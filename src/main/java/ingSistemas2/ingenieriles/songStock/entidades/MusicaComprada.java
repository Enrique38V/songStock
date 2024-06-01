package ingSistemas2.ingenieriles.songStock.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "musicacomprada")
public class MusicaComprada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmusicacomprada")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idcomprador", nullable = false)
    private Comprador comprador;

    @ManyToOne
    @JoinColumn(name = "idmusica", nullable = false)
    private Musica musica;

}