package ingSistemas2.ingenieriles.songStock.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "listamusica")
public class ListaMusica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idlistamusica")
    private Integer idListaMusica;

    @ManyToOne
    @JoinColumn(name = "idlista", nullable = false)
    private ListaReproduccion listaReproduccion;

    @ManyToOne
    @JoinColumn(name = "idmusica", nullable = false)
    private Musica musica;

}
