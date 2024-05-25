package ingSistemas2.ingenieriles.songStock.service;

import ingSistemas2.ingenieriles.songStock.entidades.ListaMusica;
import ingSistemas2.ingenieriles.songStock.entidades.ListaReproduccion;
import ingSistemas2.ingenieriles.songStock.entidades.Musica;
import ingSistemas2.ingenieriles.songStock.repositories.ListaMusicaRepository;
import ingSistemas2.ingenieriles.songStock.services.impl.ListaMusicaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ListaMusicaServiceImplTest {

    @Mock
    private ListaMusicaRepository listaMusicaRepository;

    @InjectMocks
    private ListaMusicaServiceImpl listaMusicaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void guardarCancion() {
        Musica musica = new Musica();
        ListaReproduccion listaReproduccion = new ListaReproduccion();
        ListaMusica listaMusicaGuardada = new ListaMusica();
        listaMusicaGuardada.setIdListaMusica(1);
        when(listaMusicaRepository.save(Mockito.any(ListaMusica.class))).thenReturn(listaMusicaGuardada);
        Integer idListaMusica = listaMusicaService.guardarCancion(musica, listaReproduccion);
        assertEquals(1, idListaMusica);
    }
}
