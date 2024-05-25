package ingSistemas2.ingenieriles.songStock.services.impl;

import ingSistemas2.ingenieriles.songStock.dto.ViniloDTO;
import ingSistemas2.ingenieriles.songStock.entidades.Vinilo;
import ingSistemas2.ingenieriles.songStock.helpers.ViniloHelper;
import ingSistemas2.ingenieriles.songStock.repositories.ViniloRepository;
import ingSistemas2.ingenieriles.songStock.services.ViniloService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ViniloServiceImpl implements ViniloService {

    @Autowired
    private ViniloRepository viniloRepository;
    @Autowired
    private ViniloHelper viniloHelper;

    @Override
    public void guardarVinilo(Vinilo vinilo){
        viniloRepository.save(vinilo);
    }

    @Override
    public ViniloDTO buscarViniloId(Integer idVinilo){
        Vinilo v = viniloRepository.findByIdVinilo(idVinilo);
        return viniloHelper.helperViniloToDTO(v);
    }


}
