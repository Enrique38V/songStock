package ingSistemas2.ingenieriles.songStock.helpers;

import ingSistemas2.ingenieriles.songStock.dto.MusicaDTO;
import ingSistemas2.ingenieriles.songStock.entidades.Musica;
import org.springframework.stereotype.Component;

@Component
public class MusicaHelper {


    public Musica helperMusictaToEntity(MusicaDTO musicaDTO) {
        Musica m = new Musica();
        m.setIdMusica(musicaDTO.getIdCancion());
        m.setNombre(musicaDTO.getNombre());
        m.setArtista(musicaDTO.getArtista());
        m.setGenero(musicaDTO.getGenero());
        m.setPeso(musicaDTO.getPeso());
        m.setPrecio(musicaDTO.getPrecio());
        return m;
    }
}
