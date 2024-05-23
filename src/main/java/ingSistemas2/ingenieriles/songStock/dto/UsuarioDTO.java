package ingSistemas2.ingenieriles.songStock.dto;

import ingSistemas2.ingenieriles.songStock.entidades.TipoPerfil;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * Clase  UsuarioDTO, encargado de ser el data transfer object de UsuarioDTO
 *
 * */
@Getter
@Setter
public class UsuarioDTO {

    private Integer idUsuario;
    private String nombre;
    private String apellido;
    private String usuario;
    private String contrasena;
    private String correo;
    private Integer estado;
    private TipoPerfil tipoPerfil;
}
