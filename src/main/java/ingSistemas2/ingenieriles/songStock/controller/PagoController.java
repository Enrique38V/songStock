package ingSistemas2.ingenieriles.songStock.controller;

/**
 *
 * @author Marlon Aguirre
 */
/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PagoController.java,v 1
 * Politecnico Gran colombiano (Bogot? - Colombia)
 * Ingenieria de Sistemas y Computacion
 *
 * Ejercicio: songStock
 * @author  Desarrolladores : Marlon, Camilo, Edilson, Alejandro
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

import ingSistemas2.ingenieriles.songStock.services.PagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 *
 * Clase  PagoController, encargada de recibir los llamados al servicio para la parte de Persona
 *
 * */
@RequestMapping("/Pago")
@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class PagoController {

    private final PagoService pagoService;


    /**
     * Encargado de registrar el pago
     *
     * @request tipoPago
     *            diferencia el tipo de pago que se va a realizar
     */
    @GetMapping(value = "/{tipoPago}")
    private ResponseEntity<?> consultaPersona(@PathVariable Integer tipoPago){
        pagoService.registrarPago(tipoPago);
        return ResponseEntity.ok().build();
    }

}
