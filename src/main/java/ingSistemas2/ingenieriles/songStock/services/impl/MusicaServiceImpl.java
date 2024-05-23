package ingSistemas2.ingenieriles.songStock.services.impl;


import ingSistemas2.ingenieriles.songStock.entidades.Musica;
import ingSistemas2.ingenieriles.songStock.repositories.MusicaRepostitory;
import ingSistemas2.ingenieriles.songStock.services.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicaServiceImpl implements MusicaService {

    @Autowired
    private MusicaRepostitory musicaRepostitory;

    @Override
    public void guardarCancion(Musica musica){
        musicaRepostitory.save(musica);
    }

}
