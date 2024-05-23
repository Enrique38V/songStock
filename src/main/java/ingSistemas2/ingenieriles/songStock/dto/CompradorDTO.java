package ingSistemas2.ingenieriles.songStock.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompradorDTO extends UsuarioDTO {
    private String direccion;
    private String telefono;
    private Integer idComprador;
}
