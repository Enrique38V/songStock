package ingSistemas2.ingenieriles.songStock.controller;


import ingSistemas2.ingenieriles.songStock.delegate.ListaReproduccionDelegate;
import ingSistemas2.ingenieriles.songStock.dto.ListaReproduccionDTO;
import ingSistemas2.ingenieriles.songStock.services.ListaReproduccionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/Lista")
public class ListaReproduccionController {

    private final ListaReproduccionService listaReproduccionService;

    private final ListaReproduccionDelegate listaDelegate;

    @PostMapping(value = "/crearLista")
    public void crearLista(@RequestBody ListaReproduccionDTO listaReproduccionDTO){
        listaReproduccionService.crearLista(listaReproduccionDTO);
    }

    @PostMapping(value = "/actualizarLista")
    public void actualizarLista(@RequestBody ListaReproduccionDTO listaReproduccionDTO){
        listaReproduccionService.crearLista(listaReproduccionDTO);
    }

    @DeleteMapping(value = "/borrarLista/{idLista}")
    public void borrarLista(@PathVariable Integer idLista){
        //CREAR UN DELEGATE PARA REALIZAR LA PARTE DE BORRADO
        //listaReproduccionService.crearLista(listaReproduccionDTO);
    }

    @PostMapping(value = "/agregarCancion")
    public void agregarCancion(@RequestParam Integer idLista,@RequestParam Integer idCancion){
        listaDelegate.agregarCancion(idLista, idCancion);
    }

}
