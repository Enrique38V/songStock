package ingSistemas2.ingenieriles.songStock.helpers;

import ingSistemas2.ingenieriles.songStock.dto.MusicaDTO;
import ingSistemas2.ingenieriles.songStock.entidades.Musica;
import org.springframework.stereotype.Component;

@Component
public class MusicaHelper {


    public Musica helperMusicaToEntity(MusicaDTO musicaDTO) {
        Musica m = new Musica();
        m.setIdMusica(musicaDTO.getIdCancion());
        m.setNombre(musicaDTO.getNombre());
        m.setArtista(musicaDTO.getArtista());
        m.setGenero(musicaDTO.getGenero());
        m.setPeso(musicaDTO.getPeso());
        m.setPrecio(musicaDTO.getPrecio());
        m.setDescripcion(musicaDTO.getDescricion());
        return m;
    }

    public MusicaDTO helperMusicaToDTO(Musica musica) {
        MusicaDTO m = new MusicaDTO();
        m.setIdCancion(musica.getIdMusica());
        m.setNombre(musica.getNombre());
        m.setArtista(musica.getArtista());
        m.setGenero(musica.getGenero());
        m.setPeso(musica.getPeso());
        m.setPrecio(musica.getPrecio());
        m.setDescricion(musica.getDescripcion());
        return m;
    }
}
