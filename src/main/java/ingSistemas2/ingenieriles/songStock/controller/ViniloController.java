package ingSistemas2.ingenieriles.songStock.controller;


import ingSistemas2.ingenieriles.songStock.delegate.ViniloDelegate;
import ingSistemas2.ingenieriles.songStock.dto.MusicaDTO;
import ingSistemas2.ingenieriles.songStock.dto.ViniloDTO;
import ingSistemas2.ingenieriles.songStock.services.ViniloService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/Vinilo")
public class ViniloController {

    private final ViniloDelegate viniloDelegate;

    private final ViniloService viniloService;

    @PostMapping(value = "/crear")
    public void crearVinilo(@RequestBody ViniloDTO viniloDTO){
        viniloDelegate.guardarVinilo(viniloDTO);
    }


    @PostMapping(value = "/actualizar")
    public void actualizarVinilo(@RequestBody ViniloDTO viniloDTO){
        viniloDelegate.guardarVinilo(viniloDTO);
    }

}
