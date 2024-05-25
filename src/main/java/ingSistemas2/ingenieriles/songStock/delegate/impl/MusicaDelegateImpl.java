package ingSistemas2.ingenieriles.songStock.delegate.impl;

import ingSistemas2.ingenieriles.songStock.delegate.MusicaDelegate;
import ingSistemas2.ingenieriles.songStock.dto.MusicaDTO;
import ingSistemas2.ingenieriles.songStock.entidades.Musica;
import ingSistemas2.ingenieriles.songStock.entidades.Vendedor;
import ingSistemas2.ingenieriles.songStock.helpers.MusicaHelper;
import ingSistemas2.ingenieriles.songStock.services.MusicaService;
import ingSistemas2.ingenieriles.songStock.services.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicaDelegateImpl implements MusicaDelegate {

    @Autowired
    private  MusicaService musicaService;
    @Autowired
    private  MusicaHelper musicaHelper;
    @Autowired
    private  VendedorService vendedorService;

    @Override
    public void guardarCancion(MusicaDTO musicaDTO) {
        Vendedor v = vendedorService.consultarVendedor(musicaDTO.getIdVendedor());
        if(v.getIdUsuario() != null){
            Musica m = musicaHelper.helperMusicaToEntity(musicaDTO);
            m.setVendedor(v);
            musicaService.guardarCancion(m);
        }

    }
}
