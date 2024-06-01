package ingSistemas2.ingenieriles.songStock.delegate;

import ingSistemas2.ingenieriles.songStock.dto.ViniloDTO;

import java.util.List;

public interface ViniloDelegate {

    void guardarVinilo(ViniloDTO viniloDTO);

    List<ViniloDTO> buscarCancionIdVendedor(Integer idComprador);
}
