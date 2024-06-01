package ingSistemas2.ingenieriles.songStock.services;

import ingSistemas2.ingenieriles.songStock.dto.MusicaDTO;
import ingSistemas2.ingenieriles.songStock.entidades.Musica;

import java.util.List;

public interface MusicaService {

    void guardarCancion(Musica musica);

    MusicaDTO buscarCancionId(Integer idMusica);

    List<Musica> buscarCancionCliente(Integer idVendedor);
    List<Musica> buscarCancionComprador(Integer idComprador);
}
