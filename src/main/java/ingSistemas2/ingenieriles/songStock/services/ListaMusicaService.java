package ingSistemas2.ingenieriles.songStock.services;

import ingSistemas2.ingenieriles.songStock.entidades.ListaReproduccion;
import ingSistemas2.ingenieriles.songStock.entidades.Musica;

public interface ListaMusicaService {

    Integer guardarCancion(Musica m, ListaReproduccion l);

}
