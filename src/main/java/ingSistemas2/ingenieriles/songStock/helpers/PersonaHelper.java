package ingSistemas2.ingenieriles.songStock.helpers;

import ingSistemas2.ingenieriles.songStock.dto.PersonaDTO;
import ingSistemas2.ingenieriles.songStock.entidades.Persona;

public class PersonaHelper {

    public Persona helperPersonaEntity(PersonaDTO dto){
        Persona p = new Persona();
        p.setIdPersona(dto.getIdPersona());
        p.setNombre(dto.getNombre());
        p.setApellido(dto.getApellido());
        p.setNumeroDocumento(dto.getNumeroDocumento());
        p.setTipoDocumento(dto.getTipoDocumento());
        p.setEstado(dto.getEstado());
        return p;
    }

    public PersonaDTO helperPersonaDTO(Persona p){
        PersonaDTO dto = new PersonaDTO();
        dto.setIdPersona(p.getIdPersona());
        dto.setNombre(p.getNombre());
        dto.setApellido(p.getApellido());
        dto.setTipoDocumento(p.getTipoDocumento());
        dto.setNumeroDocumento(p.getNumeroDocumento());
        dto.setEstado(p.getEstado());
        return dto;
    }
}
