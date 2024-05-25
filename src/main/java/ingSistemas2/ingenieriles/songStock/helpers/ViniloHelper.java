package ingSistemas2.ingenieriles.songStock.helpers;

import ingSistemas2.ingenieriles.songStock.dto.MusicaDTO;
import ingSistemas2.ingenieriles.songStock.dto.ViniloDTO;
import ingSistemas2.ingenieriles.songStock.entidades.Musica;
import ingSistemas2.ingenieriles.songStock.entidades.Vinilo;
import org.springframework.stereotype.Component;

@Component
public class ViniloHelper {

    public Vinilo helperViniloToEntity(ViniloDTO viniloDTO) {
        Vinilo v = new Vinilo();
        v.setIdVinilo(viniloDTO.getIdVinilo());
        v.setNombre(viniloDTO.getNombre());
        v.setArtista(viniloDTO.getArtista());
        v.setGenero(viniloDTO.getGenero());
        v.setStock(viniloDTO.getStock());
        v.setPrecio(viniloDTO.getPrecio());
        return v;
    }


    public ViniloDTO helperViniloToDTO(Vinilo vinilo) {
        ViniloDTO v = new ViniloDTO();
        v.setIdVinilo(vinilo.getIdVinilo());
        v.setNombre(vinilo.getNombre());
        v.setArtista(vinilo.getArtista());
        v.setGenero(vinilo.getGenero());
        v.setStock(vinilo.getStock());
        v.setPrecio(vinilo.getPrecio());
        return v;
    }
}
