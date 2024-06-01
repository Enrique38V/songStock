package ingSistemas2.ingenieriles.songStock.delegate;

import ingSistemas2.ingenieriles.songStock.dto.MusicaDTO;
import ingSistemas2.ingenieriles.songStock.entidades.Musica;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MusicaDelegate {

    void guardarCancion(MusicaDTO musicaDTO);

    List<MusicaDTO> buscarCancionCliente(Integer idVendedor);

    List<MusicaDTO> buscarCancionComprador(Integer idComprador);
}
