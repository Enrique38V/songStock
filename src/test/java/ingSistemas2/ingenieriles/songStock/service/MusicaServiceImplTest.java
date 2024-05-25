package ingSistemas2.ingenieriles.songStock.service;

import ingSistemas2.ingenieriles.songStock.dto.MusicaDTO;
import ingSistemas2.ingenieriles.songStock.entidades.Musica;
import ingSistemas2.ingenieriles.songStock.helpers.MusicaHelper;
import ingSistemas2.ingenieriles.songStock.repositories.MusicaRepostitory;
import ingSistemas2.ingenieriles.songStock.services.impl.MusicaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

class MusicaServiceImplTest {

    @Mock
    private MusicaRepostitory musicaRepository;

    @Mock
    private MusicaHelper musicaHelper;

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

    @Test
    void buscarCancionId() {
        Integer idMusica = 1;
        Musica musica = new Musica();
        MusicaDTO musicaDTO = new MusicaDTO();
        when(musicaRepository.findByIdMusica(any(Integer.class))).thenReturn(musica);
        when(musicaHelper.helperMusicaToDTO(any(Musica.class))).thenReturn(musicaDTO);
        MusicaDTO result = musicaService.buscarCancionId(idMusica);
        assertNotNull(result);
    }

}