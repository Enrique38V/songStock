package ingSistemas2.ingenieriles.songStock.delegate.impl;


import ingSistemas2.ingenieriles.songStock.delegate.ListaReproduccionDelegate;
import ingSistemas2.ingenieriles.songStock.dto.MusicaDTO;
import ingSistemas2.ingenieriles.songStock.entidades.ListaReproduccion;
import ingSistemas2.ingenieriles.songStock.entidades.Musica;
import ingSistemas2.ingenieriles.songStock.helpers.MusicaHelper;
import ingSistemas2.ingenieriles.songStock.services.ListaMusicaService;
import ingSistemas2.ingenieriles.songStock.services.ListaReproduccionService;
import ingSistemas2.ingenieriles.songStock.services.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListaReproduccionDelegateImpl implements ListaReproduccionDelegate {

    @Autowired
    private MusicaService musicaService;

    @Autowired
    private ListaReproduccionService listaReproduccionService;

    @Autowired
    private ListaMusicaService listaMusicaService;

    @Autowired
    private MusicaHelper musicaHelper;

    @Override
    public void agregarCancion(Integer idLista, Integer idMusica){
        try {
            MusicaDTO mDto = musicaService.buscarCancionId(idMusica);
            Musica m = musicaHelper.helperMusicaToEntity(mDto);
            ListaReproduccion lisaRep = listaReproduccionService.consultarListaId(idLista);
            Integer id = listaMusicaService.guardarCancion(m,lisaRep);
            System.out.println("Se guardo la cancion bajo el id: " + id);
        }catch (Exception ex){
            throw new RuntimeException("Ha ocurrido un error: " + ex.getMessage());
        }

    }
}
