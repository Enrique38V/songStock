package ingSistemas2.ingenieriles.songStock.delegate.impl;

import ingSistemas2.ingenieriles.songStock.delegate.ViniloDelegate;
import ingSistemas2.ingenieriles.songStock.dto.ViniloDTO;
import ingSistemas2.ingenieriles.songStock.entidades.Vendedor;
import ingSistemas2.ingenieriles.songStock.entidades.Vinilo;
import ingSistemas2.ingenieriles.songStock.helpers.ViniloHelper;
import ingSistemas2.ingenieriles.songStock.services.VendedorService;
import ingSistemas2.ingenieriles.songStock.services.ViniloService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ViniloDelegateImpl implements ViniloDelegate {

    private final ViniloService viniloService;
    private final ViniloHelper viniloHelper;
    private final VendedorService vendedorService;

    @Override
    public void guardarVinilo(ViniloDTO viniloDTO){
        Vendedor v = vendedorService.consultarVendedor(viniloDTO.getIdVendedor());
        if(v.getIdUsuario() != null){
            Vinilo m = viniloHelper.helperViniloToEntity(viniloDTO);
            m.setVendedor(v);
            viniloService.guardarVinilo(m);
        }
    }
}
