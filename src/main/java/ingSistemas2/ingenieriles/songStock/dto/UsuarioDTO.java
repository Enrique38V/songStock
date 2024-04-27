package ingSistemas2.ingenieriles.songStock.dto;


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
    private String usuario;
    private String contrasena;
    private Integer idPersona;
    private String idPerfil;
}
