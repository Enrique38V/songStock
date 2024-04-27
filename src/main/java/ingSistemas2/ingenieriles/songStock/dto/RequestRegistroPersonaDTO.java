package ingSistemas2.ingenieriles.songStock.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RequestRegistroPersonaDTO {

    private PerfilDTO perfil;
    private PersonaDTO persona;
    private UsuarioDTO usuario;
}
