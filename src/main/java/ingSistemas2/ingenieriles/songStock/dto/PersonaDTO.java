package ingSistemas2.ingenieriles.songStock.dto;


import lombok.Getter;
import lombok.Setter;



/**
 *
 * Clase  PersonaDTO, encargado de ser el data transfer object de PersonaDTO
 *
 * */
@Getter
@Setter
public class PersonaDTO {

    private Integer idPersona; //70
    private String nombre;
    private String apellido;
    private String numeroDocumento;
    private String tipoDocumento;
    private int estado;
}
