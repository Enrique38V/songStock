package ingSistemas2.ingenieriles.songStock.service;

import ingSistemas2.ingenieriles.songStock.dto.ViniloDTO;
import ingSistemas2.ingenieriles.songStock.entidades.Vinilo;
import ingSistemas2.ingenieriles.songStock.helpers.ViniloHelper;
import ingSistemas2.ingenieriles.songStock.repositories.ViniloRepository;
import ingSistemas2.ingenieriles.songStock.services.impl.ViniloServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ViniloServiceImplTest {

    @Mock
    private ViniloRepository viniloRepositoryMock;

    @InjectMocks
    private ViniloServiceImpl viniloService;

    @Mock
    private ViniloHelper viniloHelper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void guardarVinilo_LlamaAlMetodoSaveDelRepositorio() {
        Vinilo vinilo = new Vinilo();
        viniloService.guardarVinilo(vinilo);
        verify(viniloRepositoryMock).save(vinilo);
    }

    @Test
    void buscarCancionId() {
        Integer id = 1;
        Vinilo vinilo = new Vinilo();
        ViniloDTO viniloDTO = new ViniloDTO();
        when(viniloRepositoryMock.findByIdVinilo(any(Integer.class))).thenReturn(vinilo);
        when(viniloHelper.helperViniloToDTO(any(Vinilo.class))).thenReturn(viniloDTO);
        ViniloDTO result = viniloService.buscarViniloId(id);
        assertNotNull(result);
    }

}