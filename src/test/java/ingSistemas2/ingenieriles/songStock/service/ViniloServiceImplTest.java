package ingSistemas2.ingenieriles.songStock.service;

import ingSistemas2.ingenieriles.songStock.entidades.Vinilo;
import ingSistemas2.ingenieriles.songStock.repositories.ViniloRepository;
import ingSistemas2.ingenieriles.songStock.services.impl.ViniloServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class ViniloServiceImplTest {

    @Mock
    private ViniloRepository viniloRepositoryMock;

    private ViniloServiceImpl viniloService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        viniloService = new ViniloServiceImpl(viniloRepositoryMock);
    }

    @Test
    void guardarVinilo_LlamaAlMetodoSaveDelRepositorio() {
        Vinilo vinilo = new Vinilo();
        viniloService.guardarVinilo(vinilo);
        verify(viniloRepositoryMock).save(vinilo);
    }

}