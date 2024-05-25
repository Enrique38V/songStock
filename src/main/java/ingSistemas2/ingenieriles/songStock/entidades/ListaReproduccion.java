package ingSistemas2.ingenieriles.songStock.entidades;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "listareproduccion")
public class ListaReproduccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idlista")
    private Integer idLista;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcomprador")
    private Comprador comprador;

    @OneToMany(mappedBy = "listaReproduccion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ListaMusica> listaMusicas = new ArrayList<>();

}
