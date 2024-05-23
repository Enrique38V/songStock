package ingSistemas2.ingenieriles.songStock.service;

import ingSistemas2.ingenieriles.songStock.entidades.Musica;
import ingSistemas2.ingenieriles.songStock.repositories.MusicaRepostitory;
import ingSistemas2.ingenieriles.songStock.services.impl.MusicaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class MusicaServiceImplTest {

    @Mock
    private MusicaRepostitory musicaRepository;

    @InjectMocks
    private MusicaServiceImpl musicaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void guardarCancion() {
        Musica musica = new Musica();
        musicaService.guardarCancion(musica);
        verify(musicaRepository).save(musica);
    }

}