package ingSistemas2.ingenieriles.songStock.services;

import ingSistemas2.ingenieriles.songStock.dto.MusicaDTO;
import ingSistemas2.ingenieriles.songStock.entidades.Musica;

public interface MusicaService {

    void guardarCancion(Musica musica);

    MusicaDTO buscarCancionId(Integer idMusica);
}
