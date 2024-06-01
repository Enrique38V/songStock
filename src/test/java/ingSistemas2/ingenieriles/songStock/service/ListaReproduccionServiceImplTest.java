package ingSistemas2.ingenieriles.songStock.service;

import ingSistemas2.ingenieriles.songStock.dto.ListaReproduccionDTO;
import ingSistemas2.ingenieriles.songStock.entidades.ListaReproduccion;
import ingSistemas2.ingenieriles.songStock.repositories.ListaReproduccionRepository;
import ingSistemas2.ingenieriles.songStock.services.impl.ListaReproduccionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ListaReproduccionServiceImplTest {

    @Mock
    private ListaReproduccionRepository listaReproduccionRepository;

    @InjectMocks
    private ListaReproduccionServiceImpl listaReproduccionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void crearLista() {
        ListaReproduccionDTO listaDTO = new ListaReproduccionDTO();
        listaDTO.setIdUsuario(1);
        listaDTO.setNombre("Mi Lista");
        when(listaReproduccionRepository.save(any(ListaReproduccion.class))).thenReturn(new ListaReproduccion());
        //listaReproduccionService.crearLista(listaDTO);
        verify(listaReproduccionRepository, times(1)).save(any(ListaReproduccion.class));
    }

    @Test
    void consultarListaId() {
        Integer idListaReproduccion = 1;
        ListaReproduccion listaMock = new ListaReproduccion();
        when(listaReproduccionRepository.findByIdLista(idListaReproduccion)).thenReturn(listaMock);
        ListaReproduccion listaResultado = listaReproduccionService.consultarListaId(idListaReproduccion);
        assertEquals(listaMock, listaResultado);
    }
}