package ingSistemas2.ingenieriles.songStock.services.impl;

import ingSistemas2.ingenieriles.songStock.entidades.Vinilo;
import ingSistemas2.ingenieriles.songStock.repositories.ViniloRepository;
import ingSistemas2.ingenieriles.songStock.services.ViniloService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ViniloServiceImpl implements ViniloService {

    private final ViniloRepository viniloRepository;

    public void guardarVinilo(Vinilo vinilo){
        viniloRepository.save(vinilo);
    }
}
