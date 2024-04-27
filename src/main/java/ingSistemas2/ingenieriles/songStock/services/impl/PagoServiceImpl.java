package ingSistemas2.ingenieriles.songStock.services.impl;

import ingSistemas2.ingenieriles.songStock.services.PagoService;
import ingSistemas2.ingenieriles.songStock.strategy.PagoStrategy;
import ingSistemas2.ingenieriles.songStock.strategy.impl.CardStrategy;
import ingSistemas2.ingenieriles.songStock.strategy.impl.PaypalStrategy;
import org.springframework.stereotype.Service;


@Service
public class PagoServiceImpl implements PagoService {

    @Override
    public void registrarPago(Integer tipoPago) {
        PagoStrategy strategy = pagoStrategy(tipoPago);
        strategy.registroPago();
    }

    private PagoStrategy pagoStrategy(Integer tipoPago){
        PagoStrategy strategy;
        if(tipoPago==1){
            strategy = new CardStrategy();
        }else{
            strategy = new PaypalStrategy();
        }
        return strategy;
    }
}
