package ingSistemas2.ingenieriles.songStock.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Usuario")
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Column (name = "usuario")
    private String usuario;

    @Column (name = "contrasena")
    private String contrasena;

    @Column (name = "idPersona")
    private Integer idPersona;

    @Column (name = "idPerfil")
    private String idPerfil;
}

