package ingSistemas2.ingenieriles.songStock.services.impl;

import ingSistemas2.ingenieriles.songStock.dto.ListaReproduccionDTO;
import ingSistemas2.ingenieriles.songStock.entidades.Comprador;
import ingSistemas2.ingenieriles.songStock.entidades.ListaReproduccion;
import ingSistemas2.ingenieriles.songStock.repositories.ListaReproduccionRepository;
import ingSistemas2.ingenieriles.songStock.services.ListaReproduccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ListaReproduccionServiceImpl implements ListaReproduccionService {

    @Autowired
    private ListaReproduccionRepository listaReproduccionRepository;

    @Override
    public void crearLista(ListaReproduccion lista) {
        listaReproduccionRepository.save(lista);
    }

    @Override
    public ListaReproduccion consultarListaId(Integer idListaReproduccion){
        return listaReproduccionRepository.findByIdLista(idListaReproduccion);
    }

    @Override
    public List<ListaReproduccion> consultarListas(Integer idComprador){
        return listaReproduccionRepository.consultarListas(idComprador);
    }
}
