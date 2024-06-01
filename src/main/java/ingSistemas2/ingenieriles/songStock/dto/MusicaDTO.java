package ingSistemas2.ingenieriles.songStock.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.math.BigDecimal;

@Getter
@Setter
public class MusicaDTO {

    private Integer idCancion;
    private String nombre;
    private String artista;
    private String genero;
    private String descricion;
    private String peso;
    private BigDecimal precio;
    private Integer idVendedor;
    //private File cancionFile;
    //private MultipartFile imagen;
}
