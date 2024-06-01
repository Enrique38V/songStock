package ingSistemas2.ingenieriles.songStock.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class VendedorDTO extends UsuarioDTO{
    private Integer idVendedor;
    private String direccionTienda;
    private String nombreTienda;
}
