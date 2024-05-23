package ingSistemas2.ingenieriles.songStock.delegate;

import ingSistemas2.ingenieriles.songStock.delegate.impl.MusicaDelegateImpl;
import ingSistemas2.ingenieriles.songStock.dto.MusicaDTO;
import ingSistemas2.ingenieriles.songStock.entidades.Musica;
import ingSistemas2.ingenieriles.songStock.entidades.Vendedor;
import ingSistemas2.ingenieriles.songStock.helpers.MusicaHelper;
import ingSistemas2.ingenieriles.songStock.services.MusicaService;
import ingSistemas2.ingenieriles.songStock.services.VendedorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MusicaDelegateImplTest {

    @Mock
    private MusicaService musicaService;

    @Mock
    private MusicaHelper musicaHelper;

    @Mock
    private VendedorService vendedorService;

    @InjectMocks
    private MusicaDelegateImpl musicaDelegate;

    @Test
    public void testGuardarCancion() {
        // Arrange
        MusicaDTO musicaDTO = new MusicaDTO();
        musicaDTO.setIdVendedor(1); // Establecer el ID del vendedor
        Vendedor vendedor = new Vendedor();
        vendedor.setIdUsuario(1); // Establecer el ID del vendedor simulado
        Musica musica = new Musica(); // Simular la canción
        // Simular el comportamiento de los servicios y helpers
        when(vendedorService.consultarVendedor(1)).thenReturn(vendedor);
        when(musicaHelper.helperMusictaToEntity(musicaDTO)).thenReturn(musica);
        // Act
        musicaDelegate.guardarCancion(musicaDTO);
        // Assert
        verify(musicaService, times(1)).guardarCancion(musica);
    }
}