package ingSistemas2.ingenieriles.songStock.services;

import ingSistemas2.ingenieriles.songStock.dto.ViniloDTO;
import ingSistemas2.ingenieriles.songStock.entidades.Vinilo;

import java.util.List;

public interface ViniloService {

    void guardarVinilo(Vinilo vinilo);

    ViniloDTO buscarViniloId(Integer idVinilo);

    List<Vinilo> buscarViniloCliente(Integer idVendedor);
}
