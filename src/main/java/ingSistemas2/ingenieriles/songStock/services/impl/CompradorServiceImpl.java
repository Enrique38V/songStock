package ingSistemas2.ingenieriles.songStock.services.impl;

import ingSistemas2.ingenieriles.songStock.entidades.Comprador;
import ingSistemas2.ingenieriles.songStock.entidades.Vendedor;
import ingSistemas2.ingenieriles.songStock.repositories.CompradorRepository;
import ingSistemas2.ingenieriles.songStock.services.CompradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompradorServiceImpl implements CompradorService {
    @Autowired
    CompradorRepository compradorRepository;

    @Override
    public Comprador consultarComprador(Integer idComprador) {
        return compradorRepository.findByIdUsuario(idComprador);
    }
}
