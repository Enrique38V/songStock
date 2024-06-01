package ingSistemas2.ingenieriles.songStock.delegate.impl;

import ingSistemas2.ingenieriles.songStock.delegate.MusicaDelegate;
import ingSistemas2.ingenieriles.songStock.dto.MusicaDTO;
import ingSistemas2.ingenieriles.songStock.entidades.Musica;
import ingSistemas2.ingenieriles.songStock.entidades.Vendedor;
import ingSistemas2.ingenieriles.songStock.helpers.MusicaHelper;
import ingSistemas2.ingenieriles.songStock.services.MusicaService;
import ingSistemas2.ingenieriles.songStock.services.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@Service
public class MusicaDelegateImpl implements MusicaDelegate {

    @Autowired
    private  MusicaService musicaService;
    @Autowired
    private  MusicaHelper musicaHelper;
    @Autowired
    private  VendedorService vendedorService;

    @Override
    public void guardarCancion(MusicaDTO musicaDTO) {
        try {
            /*
            File cancionDest = new File("C:\\xampp\\htdocs\\songStockMusic\\" + cancionFile.getOriginalFilename());
            cancionFile.transferTo(cancionDest);
            */

            Vendedor v = vendedorService.consultarVendedor(musicaDTO.getIdVendedor());
            if (v.getIdUsuario() != null) {
                Musica m = musicaHelper.helperMusicaToEntity(musicaDTO);
                m.setVendedor(v);
                musicaService.guardarCancion(m);
            }
        }catch (Exception ex){
            System.out.println(ex);
        }

    }

    @Override
    public List<MusicaDTO> buscarCancionCliente(Integer idVendedor){
        List<Musica> m = musicaService.buscarCancionCliente(idVendedor);
        List<MusicaDTO> dto = new ArrayList<>();
        m.forEach(music ->{
            MusicaDTO cancion = musicaHelper.helperMusicaToDTO(music);
            dto.add(cancion);
        });
        return dto;
    }

    @Override
    public List<MusicaDTO> buscarCancionComprador(Integer idComprador){
        List<Musica> m = musicaService.buscarCancionCliente(idComprador);
        List<MusicaDTO> dto = new ArrayList<>();
        m.forEach(music ->{
            MusicaDTO cancion = musicaHelper.helperMusicaToDTO(music);
            dto.add(cancion);
        });
        return dto;
    }
}
