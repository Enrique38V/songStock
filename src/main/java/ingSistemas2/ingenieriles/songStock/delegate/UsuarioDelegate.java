package ingSistemas2.ingenieriles.songStock.delegate;

import ingSistemas2.ingenieriles.songStock.dto.SesionDTO;
import ingSistemas2.ingenieriles.songStock.dto.UsuarioDTO;

public interface UsuarioDelegate {

    void registroUsuario(UsuarioDTO registro);

    void inicioSesion(SesionDTO sesion);

}
