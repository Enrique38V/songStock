package ingSistemas2.ingenieriles.songStock.entidades;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Persona")
@Getter
@Setter
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPersona;

    @Column (name = "nombre")
    private String nombre;

    @Column (name = "apellido")
    private String apellido;

    @Column (name = "numeroDocumento")
    private String numeroDocumento;

    @Column (name = "tipoDocumento")
    private String tipoDocumento;

    @Column (name = "estado")
    private int estado;
}
