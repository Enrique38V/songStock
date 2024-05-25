package ingSistemas2.ingenieriles.songStock.services.impl;


import ingSistemas2.ingenieriles.songStock.dto.MusicaDTO;
import ingSistemas2.ingenieriles.songStock.entidades.Musica;
import ingSistemas2.ingenieriles.songStock.helpers.MusicaHelper;
import ingSistemas2.ingenieriles.songStock.repositories.MusicaRepostitory;
import ingSistemas2.ingenieriles.songStock.services.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicaServiceImpl implements MusicaService {

    @Autowired
    private MusicaRepostitory musicaRepostitory;

    @Autowired
    private MusicaHelper musicaHelper;

    @Override
    public void guardarCancion(Musica musica){
        musicaRepostitory.save(musica);
    }

    @Override
    public MusicaDTO buscarCancionId(Integer idMusica){
        Musica m = musicaRepostitory.findByIdMusica(idMusica);
        return musicaHelper.helperMusicaToDTO(m);
    }
}
