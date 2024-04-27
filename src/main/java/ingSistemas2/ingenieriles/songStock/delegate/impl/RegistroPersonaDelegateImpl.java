package ingSistemas2.ingenieriles.songStock.delegate.impl;


import ingSistemas2.ingenieriles.songStock.delegate.RegistroPersonaDelegate;
import ingSistemas2.ingenieriles.songStock.dto.RequestRegistroPersonaDTO;
import ingSistemas2.ingenieriles.songStock.services.PerfilService;
import ingSistemas2.ingenieriles.songStock.services.PersonaService;
import ingSistemas2.ingenieriles.songStock.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistroPersonaDelegateImpl implements RegistroPersonaDelegate{

    private final UsuarioService usuarioService;

    private final PersonaService personaService;

    @Override
    public void registroPersona(RequestRegistroPersonaDTO registro) {
        try {
            registro.getUsuario().setIdPersona(personaService.registroPersona(registro.getPersona()));
            usuarioService.registroUsuario(registro.getUsuario());
            System.out.println("se registro de forma exitosa");
        }catch (Exception ex){
            System.out.println("Se genero un error al guardar "+ ex);
        }
    }
}
