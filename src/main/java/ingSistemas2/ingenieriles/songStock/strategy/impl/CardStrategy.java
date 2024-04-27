package ingSistemas2.ingenieriles.songStock.strategy.impl;


import ingSistemas2.ingenieriles.songStock.strategy.PagoStrategy;
import org.springframework.stereotype.Service;

@Service
public class CardStrategy implements PagoStrategy{


    @Override
    public void registroPago() {
        System.out.println("Se registro el pago por tarjeta de credito");
    }
}
