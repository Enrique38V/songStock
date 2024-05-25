package ingSistemas2.ingenieriles.songStock.services.impl;

import ingSistemas2.ingenieriles.songStock.dto.ListaReproduccionDTO;
import ingSistemas2.ingenieriles.songStock.entidades.Comprador;
import ingSistemas2.ingenieriles.songStock.entidades.ListaReproduccion;
import ingSistemas2.ingenieriles.songStock.repositories.ListaReproduccionRepository;
import ingSistemas2.ingenieriles.songStock.services.ListaReproduccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ListaReproduccionServiceImpl implements ListaReproduccionService {

    @Autowired
    private ListaReproduccionRepository listaReproduccionRepository;

    @Override
    public void crearLista(ListaReproduccionDTO lista) {
        Comprador c = new Comprador();
        c.setIdUsuario(lista.getIdUsuario());
        ListaReproduccion l = new ListaReproduccion();
        l.setComprador(c);
        l.setNombre(lista.getNombre());
        l.setIdLista(lista.getIdLista());
        listaReproduccionRepository.save(l);
    }

    @Override
    public ListaReproduccion consultarListaId(Integer idListaReproduccion){
        return listaReproduccionRepository.findByIdLista(idListaReproduccion);
    }
}
