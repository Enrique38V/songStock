package ingSistemas2.ingenieriles.songStock.delegate.impl;


import ingSistemas2.ingenieriles.songStock.config.songExceptions.UsuarioCreationException;
import ingSistemas2.ingenieriles.songStock.delegate.UsuarioDelegate;
import ingSistemas2.ingenieriles.songStock.dto.MusicaDTO;
import ingSistemas2.ingenieriles.songStock.dto.SesionDTO;
import ingSistemas2.ingenieriles.songStock.dto.UsuarioDTO;
import ingSistemas2.ingenieriles.songStock.entidades.Genero;
import ingSistemas2.ingenieriles.songStock.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Base64;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UsuarioDelegateImpl implements UsuarioDelegate {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void registroUsuario(UsuarioDTO registro) throws UsuarioCreationException {
        System.out.println("registro del usuario");
        try {
            registro.setContrasena(Base64.getEncoder().encodeToString(registro.getContrasena().getBytes()));
            usuarioService.registroUsuario(registro);
            System.out.println("se registro de forma exitosa");
        }catch (Exception ex){
            System.out.println("Error registroUsuario():: " + ex);
            throw new UsuarioCreationException("No se pudo completar el registro");
        }
    }

    @Override
    public UsuarioDTO inicioSesion(SesionDTO sesion){
        try{
           sesion.setContrasena(Base64.getEncoder().encodeToString(sesion.getContrasena().getBytes()));
           UsuarioDTO usu = usuarioService.inicioSesion(sesion);
           if(usu.getIdUsuario()!=null){
               return usu;
           }
        }catch (Exception ex){
            System.out.println("Ha ocurrido un error al iniciar sesion: " + ex);
        }
        return null;
    }

    @Override
    public String consultarGenero(){
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonGenero = mapper.writeValueAsString(Genero.values());
            return jsonGenero;
        }catch (Exception ex){
            System.out.println(ex);
            return null;
        }
    }


}
