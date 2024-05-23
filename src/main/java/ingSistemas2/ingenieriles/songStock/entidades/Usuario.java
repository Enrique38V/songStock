package ingSistemas2.ingenieriles.songStock.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Usuario")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "idusuario")
    private Integer idUsuario;

    @Column (name = "nombre")
    private String nombre;

    @Column (name = "apellido")
    private String apellido;

    @Column (name = "usuario")
    private String usuario;

    @Column (name = "contrasena")
    private String contrasena;

    @Column (name = "correo")
    private String correo;

    @Column (name = "estado")
    private Integer estado;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipoperfil", insertable = false, updatable = false)
    private TipoPerfil tipoPerfil;


}

