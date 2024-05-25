package ingSistemas2.ingenieriles.songStock.services;

import ingSistemas2.ingenieriles.songStock.dto.ListaReproduccionDTO;
import ingSistemas2.ingenieriles.songStock.entidades.ListaReproduccion;

public interface ListaReproduccionService {

    void crearLista(ListaReproduccionDTO listaReproduccionDTO);

    ListaReproduccion consultarListaId(Integer idListaReproduccion);
}
