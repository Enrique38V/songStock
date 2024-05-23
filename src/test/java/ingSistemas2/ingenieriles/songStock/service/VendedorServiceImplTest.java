package ingSistemas2.ingenieriles.songStock.service;

import ingSistemas2.ingenieriles.songStock.entidades.Vendedor;
import ingSistemas2.ingenieriles.songStock.repositories.VendedorRepository;
import ingSistemas2.ingenieriles.songStock.services.impl.VendedorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class VendedorServiceImplTest {

    @Mock
    private VendedorRepository vendedorRepositoryMock;

    @InjectMocks
    private VendedorServiceImpl vendedorService;

    @BeforeEach
    void setUp() {
        // Inicializa los mocks antes de cada prueba
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void consultarVendedor_DebeRetornarElVendedorCorrecto() {
        Integer idVendedor = 1;
        Vendedor vendedorEsperado = new Vendedor();
        when(vendedorRepositoryMock.findByIdUsuario(idVendedor)).thenReturn(vendedorEsperado);
        Vendedor vendedorObtenido = vendedorService.consultarVendedor(idVendedor);
        verify(vendedorRepositoryMock).findByIdUsuario(idVendedor);
        assertEquals(vendedorEsperado, vendedorObtenido);
    }
}