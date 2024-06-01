package ingSistemas2.ingenieriles.songStock.entidades;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "vendedor")
@PrimaryKeyJoinColumn(name = "idvendedor")
public class Vendedor extends Usuario{

    @Column (name = "direcciontienda")
    private String direccionTienda;

    @Column (name = "nombretienda")
    private String nombreTienda;

    @OneToMany(mappedBy = "vendedor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Musica> musicas;


    public Vendedor(){
        super();
        this.setTipoPerfil(TipoPerfil.VENDEDOR);
    }
}
