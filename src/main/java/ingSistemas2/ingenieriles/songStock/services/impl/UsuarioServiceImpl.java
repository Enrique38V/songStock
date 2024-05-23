package ingSistemas2.ingenieriles.songStock.services.impl;

import ingSistemas2.ingenieriles.songStock.config.songExceptions.UsuarioFoundException;
import ingSistemas2.ingenieriles.songStock.dto.SesionDTO;
import ingSistemas2.ingenieriles.songStock.dto.UsuarioDTO;
import ingSistemas2.ingenieriles.songStock.entidades.Usuario;
import ingSistemas2.ingenieriles.songStock.helpers.UsuarioHelper;
import ingSistemas2.ingenieriles.songStock.repositories.UsuarioRepository;
import ingSistemas2.ingenieriles.songStock.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final UsuarioHelper usuarioHelper;

    @Override
    public Integer registroUsuario(UsuarioDTO usuarioDTO) throws UsuarioFoundException{
            if (validacionRegistro(usuarioDTO)) {
                Usuario usu = usuarioHelper.helperUsuarioDTOToEntity(usuarioDTO);
                usu = usuarioRepository.save(usu);
                return usu.getIdUsuario();
            }
            throw new UsuarioFoundException("Ya existe un usuario creado con esos datos");
    }

    private Boolean validacionRegistro(UsuarioDTO usuarioDTO){
        List<Usuario> usuCreados = usuarioRepository.findByUsuarioAndCorreo(usuarioDTO.getUsuario(), usuarioDTO.getCorreo());
        if(usuCreados.isEmpty()){
            return true;
        }
        return false;
    }

    @Override
    public void actualizarUsuario(UsuarioDTO usuarioDTO){
        Usuario usu = usuarioHelper.helperUsuarioDTOToEntity(usuarioDTO);
        usuarioRepository.save(usu);
    }

    @Override
    public UsuarioDTO consultaUsuario(Integer idUsuario) {
        return usuarioHelper.helperUsuarioToDTO(usuarioRepository.findByIdUsuario(idUsuario));
    }

    @Override
    public UsuarioDTO inicioSesion(SesionDTO sesion){
        return usuarioHelper.helperUsuarioToDTO(usuarioRepository.findByContrasenaAndCorreo(sesion.getContrasena(), sesion.getCorreo()));
    }
}
