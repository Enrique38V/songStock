package ingSistemas2.ingenieriles.songStock.entidades;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "comprador")
@PrimaryKeyJoinColumn(name = "idcomprador")
public class Comprador extends Usuario {

    @Column(name = "direccion")
    private String direccion;

    @Column (name = "telefono")
    private String telefono;

    public Comprador(){
        super();
        this.setTipoPerfil(TipoPerfil.COMPRADOR);
    }

}
