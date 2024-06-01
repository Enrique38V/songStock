package ingSistemas2.ingenieriles.songStock.delegate.impl;


import ingSistemas2.ingenieriles.songStock.delegate.ListaReproduccionDelegate;
import ingSistemas2.ingenieriles.songStock.dto.ListaReproduccionDTO;
import ingSistemas2.ingenieriles.songStock.dto.MusicaDTO;
import ingSistemas2.ingenieriles.songStock.dto.UsuarioDTO;
import ingSistemas2.ingenieriles.songStock.entidades.Comprador;
import ingSistemas2.ingenieriles.songStock.entidades.ListaReproduccion;
import ingSistemas2.ingenieriles.songStock.entidades.Musica;
import ingSistemas2.ingenieriles.songStock.entidades.Usuario;
import ingSistemas2.ingenieriles.songStock.helpers.MusicaHelper;
import ingSistemas2.ingenieriles.songStock.helpers.UsuarioHelper;
import ingSistemas2.ingenieriles.songStock.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private CompradorService compradorService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioHelper usuarioHelper;

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

    @Override
    public void crearLista(ListaReproduccionDTO listaReproduccionDTO){
        try{
            Comprador com= compradorService.consultarComprador(listaReproduccionDTO.getIdUsuario());
            ListaReproduccion l = new ListaReproduccion();
            l.setComprador(com);
            l.setNombre(listaReproduccionDTO.getNombre());
            l.setIdLista(listaReproduccionDTO.getIdLista());
            l.setDescripcion(listaReproduccionDTO.getDescripcion());
            listaReproduccionService.crearLista(l);
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<ListaReproduccionDTO> consultarListas(Integer idComprador){
        List<ListaReproduccion> lr = listaReproduccionService.consultarListas(idComprador);
        List<ListaReproduccionDTO> listResponse = new ArrayList<>();
        lr.forEach(item-> {
            ListaReproduccionDTO dto = new ListaReproduccionDTO();
            //dto.setIdUsuario(item.getComprador().getIdUsuario());
            dto.setDescripcion(item.getDescripcion());
            dto.setNombre(item.getNombre());
            dto.setIdLista(item.getIdLista());
            listResponse.add(dto);
        });
        return listResponse;
    }
}
