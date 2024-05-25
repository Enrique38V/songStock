package ingSistemas2.ingenieriles.songStock.delegate.impl;


import ingSistemas2.ingenieriles.songStock.delegate.UsuarioDelegate;
import ingSistemas2.ingenieriles.songStock.dto.SesionDTO;
import ingSistemas2.ingenieriles.songStock.dto.UsuarioDTO;
import ingSistemas2.ingenieriles.songStock.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Base64;

@Service
public class UsuarioDelegateImpl implements UsuarioDelegate {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void registroUsuario(UsuarioDTO registro) {
        try {
            registro.setContrasena(Base64.getEncoder().encodeToString(registro.getContrasena().getBytes()));
            usuarioService.registroUsuario(registro);
            System.out.println("se registro de forma exitosa");
        }catch (Exception ex){
            System.out.println("Se genero un error al guardar "+ ex);
        }
    }

    @Override
    public void inicioSesion(SesionDTO sesion){
        try{
           sesion.setContrasena(Base64.getEncoder().encodeToString(sesion.getContrasena().getBytes()));
           usuarioService.inicioSesion(sesion);
           System.out.println("El usuario inicio sesion exitosamente");
        }catch (Exception ex){
            System.out.println("Ha ocurrido un error al iniciar sesion: " + ex);
        }
    }


}
