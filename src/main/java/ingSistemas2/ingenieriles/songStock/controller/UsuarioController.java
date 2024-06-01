package ingSistemas2.ingenieriles.songStock.controller;


/**
 *
 * @author Marlon Aguirre
 */
/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: UsuarioController.java,v 1
 * Politecnico Gran colombiano (Bogot? - Colombia)
 * Ingenieria de Sistemas y Computacion
 *
 * Ejercicio: songStock
 * @author  Desarrolladores : Marlon, Camilo, Edilson, Alejandro
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

import ingSistemas2.ingenieriles.songStock.config.songExceptions.UsuarioCreationException;
import ingSistemas2.ingenieriles.songStock.delegate.UsuarioDelegate;
import ingSistemas2.ingenieriles.songStock.dto.SesionDTO;
import ingSistemas2.ingenieriles.songStock.dto.UsuarioDTO;
import ingSistemas2.ingenieriles.songStock.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
*
 * Clase  UsuarioController, encargada de recibir los llamados al servicio para la parte de Usuarios
*
* */

@RequestMapping("/Usuario")
@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    private final UsuarioDelegate usuarioDelegate;

    /**
     * Encargado del primer registro de Usuario
     *
     * @request RequestRegistroPersonaDTO
     *            objeto con los datos de registro
     */
    @PostMapping(value = "/registro")
    private ResponseEntity<?> registroUsuario(@RequestBody UsuarioDTO usuarioDTO) throws UsuarioCreationException {
        try {
            System.out.println(usuarioDTO.getUsuario());
            System.out.println(usuarioDTO.getContrasena());
            usuarioDelegate.registroUsuario(usuarioDTO);
        }catch (UsuarioCreationException ex){
            return ResponseEntity.badRequest().body("Por favor completar bien los campos");
        }
        return ResponseEntity.ok("funcionando ando");
    }

    /**
     * Encargado de consultar a la Usuario por su Id
     *
     * @request idUsuario
     *            numero entero que corresponde al Id de la Usuario
     */
    @GetMapping(value = "/{idUsuario}")
    private ResponseEntity<?> consultaUsuario(@PathVariable Integer idUsuario){
        UsuarioDTO  usu = usuarioService.consultaUsuario(idUsuario);
        if(usu == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usu);
    }

    /**
     * Encargado de editar a la Usuario
     *
     * @request UsuarioDTO
     *            Objeto con los datos de la Usuario
     */
    @PostMapping(value = "/editar")
    private ResponseEntity<?> actualizarPersona(@RequestBody UsuarioDTO usuarioDTO){
        usuarioService.actualizarUsuario(usuarioDTO);
        return ResponseEntity.ok().build();
    }

    /**
     * Encargado de iniciar la sesion del Usuario
     *
     * @request UsuarioDTO
     *            Objeto con los datos de la Usuario
     */
    @PostMapping(value = "/inicarSesion")
    private ResponseEntity<?> inicioSesison(@RequestBody SesionDTO sesion){
        UsuarioDTO usu = usuarioDelegate.inicioSesion(sesion);
        if(usu == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usu);
    }

    /**
     * Encargado de cambiar el estado del Usuario a deshabilitado
     *
     * @request idUsuario
     *            Objeto con los datos de la Usuario
     */
    @GetMapping(value = "/deshabilitar/{idUsuario}")
    private ResponseEntity<?> deshabilitarUsuario(@PathVariable Integer idUsuario){
        usuarioService.cambiarEstado(idUsuario, 2);
        return ResponseEntity.ok().build();
    }

    /**
     * Encargado de cambiar el estado del Usuario a habilitado
     *
     * @request idUsuario
     *            Objeto con los datos de la Usuario
     */
    @GetMapping(value = "/habilitar/{idUsuario}")
    private ResponseEntity<?> habilitarUsuario(@PathVariable Integer idUsuario){
        usuarioService.cambiarEstado(idUsuario, 1);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/generos")
    private ResponseEntity<?>consultarGeneros(){
        String json = usuarioDelegate.consultarGenero();
        return ResponseEntity.ok(json);
    }
}
