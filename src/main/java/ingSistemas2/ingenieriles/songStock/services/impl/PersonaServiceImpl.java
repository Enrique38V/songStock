package ingSistemas2.ingenieriles.songStock.services.impl;

import ingSistemas2.ingenieriles.songStock.dto.PersonaDTO;
import ingSistemas2.ingenieriles.songStock.entidades.Persona;
import ingSistemas2.ingenieriles.songStock.helpers.PersonaHelper;
import ingSistemas2.ingenieriles.songStock.repositories.PersonaRepository;
import ingSistemas2.ingenieriles.songStock.services.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;
    private final PersonaHelper personaHelper;

    @Override
    public Integer registroPersona(PersonaDTO persona) {
        Persona p = personaHelper.helperPersonaEntity(persona);
        p = personaRepository.save(p);
        return p.getIdPersona();
    }

    @Override
    public PersonaDTO consultaPersona(Integer idPersona) {
        Persona p = personaRepository.findByIdPersona(idPersona);
        PersonaDTO persona = personaHelper.helperPersonaDTO(p);
        return persona;
    }
}
