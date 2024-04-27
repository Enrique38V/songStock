package ingSistemas2.ingenieriles.songStock.services.impl;

import ingSistemas2.ingenieriles.songStock.dto.UsuarioDTO;
import ingSistemas2.ingenieriles.songStock.entidades.Usuario;
import ingSistemas2.ingenieriles.songStock.helpers.UsuarioHelper;
import ingSistemas2.ingenieriles.songStock.repositories.UsuarioRepository;
import ingSistemas2.ingenieriles.songStock.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final UsuarioHelper usuarioHelper;

    @Override
    public Integer registroUsuario(UsuarioDTO usuarioDTO){
        Usuario usu = usuarioHelper.helperUsuarioToEntity(usuarioDTO);
        usu = usuarioRepository.save(usu);
        return usu.getIdUsuario();
    }
}
