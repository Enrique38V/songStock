package ingSistemas2.ingenieriles.songStock.delegate;

import ingSistemas2.ingenieriles.songStock.delegate.impl.ViniloDelegateImpl;
import ingSistemas2.ingenieriles.songStock.dto.ViniloDTO;
import ingSistemas2.ingenieriles.songStock.entidades.Vendedor;
import ingSistemas2.ingenieriles.songStock.entidades.Vinilo;
import ingSistemas2.ingenieriles.songStock.helpers.ViniloHelper;
import ingSistemas2.ingenieriles.songStock.services.VendedorService;
import ingSistemas2.ingenieriles.songStock.services.ViniloService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ViniloDelegateImplTest {

    @Mock
    private ViniloService viniloService;

    @Mock
    private ViniloHelper viniloHelper;

    @Mock
    private VendedorService vendedorService;

    @InjectMocks
    private ViniloDelegateImpl viniloDelegate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGuardarVinilo() {
        ViniloDTO viniloDTO = new ViniloDTO();
        viniloDTO.setIdVendedor(1);
        Vendedor vendedor = new Vendedor();
        vendedor.setIdUsuario(1);
        Vinilo vinilo = new Vinilo();
        vinilo.setIdVinilo(1);
        when(vendedorService.consultarVendedor(anyInt())).thenReturn(vendedor);
        when(viniloHelper.helperViniloToEntity(viniloDTO)).thenReturn(vinilo);
        viniloDelegate.guardarVinilo(viniloDTO);
        verify(viniloService).guardarVinilo(vinilo);
    }
}