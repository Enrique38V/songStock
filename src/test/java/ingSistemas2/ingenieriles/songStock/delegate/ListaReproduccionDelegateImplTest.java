package ingSistemas2.ingenieriles.songStock.delegate;


import ingSistemas2.ingenieriles.songStock.delegate.impl.ListaReproduccionDelegateImpl;
import ingSistemas2.ingenieriles.songStock.dto.MusicaDTO;
import ingSistemas2.ingenieriles.songStock.entidades.ListaReproduccion;
import ingSistemas2.ingenieriles.songStock.entidades.Musica;
import ingSistemas2.ingenieriles.songStock.helpers.MusicaHelper;
import ingSistemas2.ingenieriles.songStock.services.ListaMusicaService;
import ingSistemas2.ingenieriles.songStock.services.ListaReproduccionService;
import ingSistemas2.ingenieriles.songStock.services.MusicaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
public class ListaReproduccionDelegateImplTest {

    @Mock
    private MusicaService musicaService;

    @Mock
    private ListaReproduccionService listaReproduccionService;

    @Mock
    private ListaMusicaService listaMusicaService;

    @Mock
    private MusicaHelper musicaHelper;

    @InjectMocks
    private ListaReproduccionDelegateImpl listaReproduccionDelegate;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void agregarCancion_ValidIds_CallsServices() {
        Integer idLista = 1;
        Integer idMusica = 1;
        MusicaDTO musicaDTO = new MusicaDTO();
        when(musicaService.buscarCancionId(anyInt())).thenReturn(musicaDTO);
        ListaReproduccion listaReproduccion = new ListaReproduccion();
        when(listaReproduccionService.consultarListaId(anyInt())).thenReturn(listaReproduccion);
        Musica musica = new Musica();
        when(musicaHelper.helperMusicaToEntity(musicaDTO)).thenReturn(musica);
        when(listaMusicaService.guardarCancion(any(Musica.class), any(ListaReproduccion.class))).thenReturn(1);
        listaReproduccionDelegate.agregarCancion(idLista, idMusica);
        verify(musicaService, times(1)).buscarCancionId(idMusica);
        verify(listaReproduccionService, times(1)).consultarListaId(idLista);
        verify(musicaHelper, times(1)).helperMusicaToEntity(musicaDTO);
        verify(listaMusicaService, times(1)).guardarCancion(musica, listaReproduccion);
    }

    @Test
    public void agregarCancion_ExceptionThrown_PrintsErrorMessage() {
        // Arrange
        Integer idLista = 1;
        Integer idMusica = 1;
        MusicaDTO musicaDTO = new MusicaDTO();
        when(musicaService.buscarCancionId(anyInt())).thenReturn(musicaDTO);
        ListaReproduccion listaReproduccion = new ListaReproduccion();
        when(listaReproduccionService.consultarListaId(anyInt())).thenReturn(listaReproduccion);
        Musica musica = new Musica();
        when(musicaHelper.helperMusicaToEntity(musicaDTO)).thenReturn(musica);
        when(listaMusicaService.guardarCancion(any(Musica.class), any(ListaReproduccion.class)))
                .thenThrow(new RuntimeException("Error mockeado"));
        assertThrows(RuntimeException.class, () -> listaReproduccionDelegate.agregarCancion(idLista, idMusica));
    }
}
