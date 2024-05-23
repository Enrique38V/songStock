package ingSistemas2.ingenieriles.songStock.dto;


import ingSistemas2.ingenieriles.songStock.entidades.Vendedor;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ViniloDTO {

    private Integer idVinilo;
    private String nombre;
    private String artista;
    private String genero;
    private Integer stock;
    private BigDecimal precio;
    private Integer idVendedor;

}
