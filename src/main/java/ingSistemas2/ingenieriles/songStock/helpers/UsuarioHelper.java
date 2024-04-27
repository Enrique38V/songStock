package ingSistemas2.ingenieriles.songStock.helpers;

import ingSistemas2.ingenieriles.songStock.dto.PersonaDTO;
import ingSistemas2.ingenieriles.songStock.dto.UsuarioDTO;
import ingSistemas2.ingenieriles.songStock.entidades.Persona;
import ingSistemas2.ingenieriles.songStock.entidades.Usuario;

public class UsuarioHelper {


    public Usuario helperUsuarioToEntity(UsuarioDTO dto){
        Usuario u = new Usuario();
        u.setIdPersona(dto.getIdPersona());
        u.setUsuario(dto.getUsuario());
        u.setContrasena(dto.getContrasena());
        u.setIdPerfil(dto.getIdPerfil());
        return u;
    }
}
