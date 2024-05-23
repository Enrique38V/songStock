package ingSistemas2.ingenieriles.songStock.dto;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class MusicaDTO {

    private Integer idCancion;
    private String nombre;
    private String artista;
    private String genero;
    private String peso;
    private BigDecimal precio;
    private Integer idVendedor;
}
