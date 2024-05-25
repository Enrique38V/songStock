package ingSistemas2.ingenieriles.songStock.services.impl;


import ingSistemas2.ingenieriles.songStock.entidades.ListaMusica;
import ingSistemas2.ingenieriles.songStock.entidades.ListaReproduccion;
import ingSistemas2.ingenieriles.songStock.entidades.Musica;
import ingSistemas2.ingenieriles.songStock.repositories.ListaMusicaRepository;
import ingSistemas2.ingenieriles.songStock.services.ListaMusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListaMusicaServiceImpl implements ListaMusicaService {

    @Autowired
    private ListaMusicaRepository listaMusicaRepository;


    public Integer guardarCancion(Musica m, ListaReproduccion l){
        ListaMusica lista =  new ListaMusica();
        lista.setListaReproduccion(l);
        lista.setMusica(m);
        lista = listaMusicaRepository.save(lista);
        return lista.getIdListaMusica();
    }
}
