package ingSistemas2.ingenieriles.songStock.controller;


import ingSistemas2.ingenieriles.songStock.delegate.MusicaDelegate;
import ingSistemas2.ingenieriles.songStock.dto.MusicaDTO;
import ingSistemas2.ingenieriles.songStock.services.MusicaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Musica")
@CrossOrigin(origins = "*")
public class MusicaController {


    private final MusicaService musicaService;

    private final MusicaDelegate musicaDelegate;

    @PostMapping(value = "/crear")
    public void crearCancion(@RequestBody MusicaDTO musicaDTO){
        musicaDelegate.guardarCancion(musicaDTO);
    }

    @PostMapping(value = "/actualizar")
    public void actualizarCancion(@RequestBody MusicaDTO musicaDTO){
        musicaDelegate.guardarCancion(musicaDTO);
    }

    @GetMapping(value = "/buscar/{id}")
    public MusicaDTO buscarCancion(@PathVariable Integer idMusica){
        return musicaService.buscarCancionId(idMusica);
    }


}
