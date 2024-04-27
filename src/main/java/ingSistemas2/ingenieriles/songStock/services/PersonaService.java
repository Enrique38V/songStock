package ingSistemas2.ingenieriles.songStock.services;

import ingSistemas2.ingenieriles.songStock.dto.PersonaDTO;

public interface PersonaService {


    Integer registroPersona(PersonaDTO persona);

    PersonaDTO consultaPersona(Integer idPersona);

}
