package ingSistemas2.ingenieriles.songStock.services.impl;



import ingSistemas2.ingenieriles.songStock.dto.VendedorDTO;
import ingSistemas2.ingenieriles.songStock.entidades.Vendedor;
import ingSistemas2.ingenieriles.songStock.repositories.VendedorRepository;
import ingSistemas2.ingenieriles.songStock.services.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class VendedorServiceImpl implements VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    @Override
    public Vendedor consultarVendedor(Integer idVendedor) {
        return vendedorRepository.findByIdUsuario(idVendedor);
    }

}
