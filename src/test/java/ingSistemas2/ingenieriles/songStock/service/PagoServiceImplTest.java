package ingSistemas2.ingenieriles.songStock.service;
import ingSistemas2.ingenieriles.songStock.services.impl.PagoServiceImpl;
import ingSistemas2.ingenieriles.songStock.strategy.impl.CardStrategy;
import ingSistemas2.ingenieriles.songStock.strategy.impl.PaypalStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class PagoServiceImplTest {

    @Mock
    private CardStrategy cardStrategyMock;

    @Mock
    private PaypalStrategy paypalStrategyMock;

    @Mock
    private PagoServiceImpl pagoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        pagoService = new PagoServiceImpl();
    }

    @Test
    void registrarPago_UtilizaEstrategiaTarjeta() {
        Integer tipoPago = 1;
        pagoService.registrarPago(tipoPago);
        verify(cardStrategyMock).registroPago();
    }

    @Test
    void registrarPago_UtilizaEstrategiaPaypal() {
        Integer tipoPago = 2;
        pagoService.registrarPago(tipoPago);
        verify(paypalStrategyMock).registroPago();
    }

}