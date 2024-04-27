package ingSistemas2.ingenieriles.songStock.controller;


/**
 *
 * @author Marlon Aguirre
 */
/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PersonaController.java,v 1
 * Politecnico Gran colombiano (Bogot? - Colombia)
 * Ingenieria de Sistemas y Computacion
 *
 * Ejercicio: songStock
 * @author  Desarrolladores : Marlon, Camilo, Edilson, Alejandro
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

import ingSistemas2.ingenieriles.songStock.delegate.RegistroPersonaDelegate;
import ingSistemas2.ingenieriles.songStock.dto.PersonaDTO;
import ingSistemas2.ingenieriles.songStock.dto.RequestRegistroPersonaDTO;
import ingSistemas2.ingenieriles.songStock.services.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
*
 * Clase  PersonaController, encargada de recibir los llamados al servicio para la parte de Persona
*
* */

@RequestMapping("/Persona")
@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class PersonaController {

    private final PersonaService personaService;

    private final RegistroPersonaDelegate registroPersonaDelegate;

    /**
     * Encargado del primer registro de Persona
     *
     * @request RequestRegistroPersonaDTO
     *            objeto con los datos de registro
     */
    @PostMapping(value = "/registro")
    private ResponseEntity<?> registroPersona(@RequestBody RequestRegistroPersonaDTO registro){
        registroPersonaDelegate.registroPersona(registro);
        return ResponseEntity.ok().build();
    }

    /**
     * Encargado de consultar a la persona por su Id
     *
     * @request idPersona
     *            numero entero que conrresponde al Id de la persona
     */
    @GetMapping(value = "/{idPersona}")
    private ResponseEntity<?> consultaPersona(@PathVariable Integer idPersona){
        personaService.consultaPersona(idPersona);
        return ResponseEntity.ok().build();
    }

    /**
     * Encargado de editar a la persona
     *
     * @request PersonaDTO
     *            Objeto con los datos de la persona
     */
    @PostMapping(value = "/editar")
    private ResponseEntity<?> actualizarPersona(@RequestBody PersonaDTO persona){
        personaService.registroPersona(persona);
        return ResponseEntity.ok().build();
    }
}
