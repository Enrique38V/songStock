package ingSistemas2.ingenieriles.songStock.delegate;

import ingSistemas2.ingenieriles.songStock.dto.ListaReproduccionDTO;

import java.util.List;

public interface ListaReproduccionDelegate {

    void  agregarCancion(Integer idLista, Integer idMusica);

    void crearLista(ListaReproduccionDTO listaReproduccionDTO);

    List<ListaReproduccionDTO> consultarListas(Integer idComprador);
}
