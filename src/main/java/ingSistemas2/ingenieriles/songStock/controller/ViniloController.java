package ingSistemas2.ingenieriles.songStock.controller;


import ingSistemas2.ingenieriles.songStock.delegate.ViniloDelegate;
import ingSistemas2.ingenieriles.songStock.dto.MusicaDTO;
import ingSistemas2.ingenieriles.songStock.dto.ViniloDTO;
import ingSistemas2.ingenieriles.songStock.services.ViniloService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = "/buscar/{id}")
    public ViniloDTO buscarVinilo(@PathVariable Integer idVinilo){
        return viniloService.buscarViniloId(idVinilo);
    }

    @GetMapping(value = "/buscar/cancionesVendedor/{idVendedor}")
    public ResponseEntity<?> buscarCancionComprador(@PathVariable Integer idVendedor){
        List<ViniloDTO> music =  viniloDelegate.buscarCancionIdVendedor(idVendedor);
        if(music == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(music);
    }

}
