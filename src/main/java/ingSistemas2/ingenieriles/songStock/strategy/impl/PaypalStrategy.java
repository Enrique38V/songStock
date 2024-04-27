package ingSistemas2.ingenieriles.songStock.strategy.impl;

import ingSistemas2.ingenieriles.songStock.strategy.PagoStrategy;
import org.springframework.stereotype.Service;


@Service
public class PaypalStrategy implements PagoStrategy {


    @Override
    public void registroPago() {
        System.out.println("Se registro el pago por Pay pal");
    }
}
