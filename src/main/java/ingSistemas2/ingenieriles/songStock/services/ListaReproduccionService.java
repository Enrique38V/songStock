package ingSistemas2.ingenieriles.songStock.services;

import ingSistemas2.ingenieriles.songStock.dto.ListaReproduccionDTO;
import ingSistemas2.ingenieriles.songStock.entidades.ListaReproduccion;

import java.util.List;

public interface ListaReproduccionService {

    void crearLista(ListaReproduccion listaReproduccionDTO);

    ListaReproduccion consultarListaId(Integer idListaReproduccion);

    List<ListaReproduccion> consultarListas(Integer idComprador);
}
