package ingSistemas2.ingenieriles.songStock.helpers;

import ingSistemas2.ingenieriles.songStock.dto.CompradorDTO;
import ingSistemas2.ingenieriles.songStock.dto.VendedorDTO;
import ingSistemas2.ingenieriles.songStock.entidades.Comprador;
import ingSistemas2.ingenieriles.songStock.entidades.TipoPerfil;
import ingSistemas2.ingenieriles.songStock.entidades.Usuario;
import ingSistemas2.ingenieriles.songStock.entidades.Vendedor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UsuarioHelperTest {

    private final UsuarioHelper usuarioHelper = new UsuarioHelper();

    @Test
    void helperUsuarioDTOToEntity_DebeRetornarCompradorCorrecto() {
        // Dado un DTO de comprador
        CompradorDTO compradorDTO = new CompradorDTO();
        compradorDTO.setNombre("Juan");
        compradorDTO.setApellido("Perez");
        compradorDTO.setUsuario("juan123");
        compradorDTO.setContrasena("contraseña123");
        compradorDTO.setCorreo("juan@example.com");
        compradorDTO.setEstado(1);
        compradorDTO.setTipoPerfil(TipoPerfil.COMPRADOR);
        compradorDTO.setDireccion("Calle 123");
        compradorDTO.setTelefono("123456789");
        Usuario usuario = usuarioHelper.helperUsuarioDTOToEntity(compradorDTO);
        assertEquals(compradorDTO.getNombre(), ((Comprador) usuario).getNombre());
        assertEquals(compradorDTO.getApellido(), ((Comprador) usuario).getApellido());
        assertEquals(compradorDTO.getUsuario(), ((Comprador) usuario).getUsuario());
        assertEquals(compradorDTO.getContrasena(), ((Comprador) usuario).getContrasena());
        assertEquals(compradorDTO.getCorreo(), ((Comprador) usuario).getCorreo());
        assertEquals(compradorDTO.getEstado(), ((Comprador) usuario).getEstado());
        assertEquals(compradorDTO.getTipoPerfil(), ((Comprador) usuario).getTipoPerfil());
        assertEquals(compradorDTO.getDireccion(), ((Comprador) usuario).getDireccion());
        assertEquals(compradorDTO.getTelefono(), ((Comprador) usuario).getTelefono());
    }

    @Test
    void helperUsuarioDTOToEntity_DebeRetornarVendedorCorrecto() {
        // Dado un DTO de vendedor
        VendedorDTO vendedorDTO = new VendedorDTO();
        vendedorDTO.setNombre("Maria");
        vendedorDTO.setApellido("Gomez");
        vendedorDTO.setUsuario("maria123");
        vendedorDTO.setContrasena("contraseña456");
        vendedorDTO.setCorreo("maria@example.com");
        vendedorDTO.setEstado(1);
        vendedorDTO.setTipoPerfil(TipoPerfil.VENDEDOR);
        vendedorDTO.setNombreTienda("Tienda de Maria");
        vendedorDTO.setDireccionTienda("Avenida Principal");
        Usuario usuario = usuarioHelper.helperUsuarioDTOToEntity(vendedorDTO);
        assertEquals(vendedorDTO.getNombre(), ((Vendedor) usuario).getNombre());
        assertEquals(vendedorDTO.getApellido(), ((Vendedor) usuario).getApellido());
        assertEquals(vendedorDTO.getUsuario(), ((Vendedor) usuario).getUsuario());
        assertEquals(vendedorDTO.getContrasena(), ((Vendedor) usuario).getContrasena());
        assertEquals(vendedorDTO.getCorreo(), ((Vendedor) usuario).getCorreo());
        assertEquals(vendedorDTO.getEstado(), ((Vendedor) usuario).getEstado());
        assertEquals(vendedorDTO.getTipoPerfil(), ((Vendedor) usuario).getTipoPerfil());
        assertEquals(vendedorDTO.getNombreTienda(), ((Vendedor) usuario).getNombreTienda());
        assertEquals(vendedorDTO.getDireccionTienda(), ((Vendedor) usuario).getDireccionTienda());
    }
}
