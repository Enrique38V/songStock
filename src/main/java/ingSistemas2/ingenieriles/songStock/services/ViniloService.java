package ingSistemas2.ingenieriles.songStock.services;

import ingSistemas2.ingenieriles.songStock.dto.ViniloDTO;
import ingSistemas2.ingenieriles.songStock.entidades.Vinilo;

public interface ViniloService {

    void guardarVinilo(Vinilo vinilo);

    ViniloDTO buscarViniloId(Integer idVinilo);
}
