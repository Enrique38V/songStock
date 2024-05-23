package ingSistemas2.ingenieriles.songStock.helpers;

import ingSistemas2.ingenieriles.songStock.dto.CompradorDTO;
import ingSistemas2.ingenieriles.songStock.dto.UsuarioDTO;
import ingSistemas2.ingenieriles.songStock.dto.VendedorDTO;
import ingSistemas2.ingenieriles.songStock.entidades.Comprador;
import ingSistemas2.ingenieriles.songStock.entidades.TipoPerfil;
import ingSistemas2.ingenieriles.songStock.entidades.Usuario;
import ingSistemas2.ingenieriles.songStock.entidades.Vendedor;
import org.springframework.stereotype.Component;

@Component
public class UsuarioHelper {


    public Usuario helperUsuarioDTOToEntity(UsuarioDTO usuarioDTO){
        if (usuarioDTO instanceof CompradorDTO) {
            CompradorDTO dto = (CompradorDTO) usuarioDTO;
            Comprador comprador = new Comprador();
            comprador.setNombre(dto.getNombre());
            comprador.setApellido(dto.getApellido());
            comprador.setUsuario(dto.getUsuario());
            comprador.setContrasena(dto.getContrasena());
            comprador.setCorreo(dto.getCorreo());
            comprador.setEstado(dto.getEstado());
            comprador.setTipoPerfil(dto.getTipoPerfil());
            comprador.setDireccion(dto.getDireccion());
            comprador.setTelefono(dto.getTelefono());
            return comprador;
        } else if (usuarioDTO instanceof VendedorDTO) {
            VendedorDTO dto = (VendedorDTO) usuarioDTO;
            Vendedor vendedor = new Vendedor();
            vendedor.setNombre(dto.getNombre());
            vendedor.setApellido(dto.getApellido());
            vendedor.setUsuario(dto.getUsuario());
            vendedor.setContrasena(dto.getContrasena());
            vendedor.setCorreo(dto.getCorreo());
            vendedor.setEstado(dto.getEstado());
            vendedor.setTipoPerfil(dto.getTipoPerfil());
            vendedor.setNombreTienda(dto.getNombreTienda());
            vendedor.setDireccionTienda(dto.getDireccionTienda());
            return vendedor;
        }
        return null;
    }

    public UsuarioDTO helperUsuarioToDTO(Usuario usuario){
        if (usuario.getTipoPerfil() == TipoPerfil.COMPRADOR) {
            Comprador comprador = (Comprador) usuario;
            CompradorDTO dto = new CompradorDTO();
            dto.setNombre(comprador.getNombre());
            dto.setApellido(comprador.getApellido());
            dto.setUsuario(comprador.getUsuario());
            dto.setContrasena(comprador.getContrasena());
            dto.setCorreo(comprador.getCorreo());
            dto.setEstado(comprador.getEstado());
            dto.setTipoPerfil(comprador.getTipoPerfil());
            dto.setDireccion(comprador.getDireccion());
            dto.setTelefono(comprador.getTelefono());
            return dto;
        } else if (usuario.getTipoPerfil() == TipoPerfil.VENDEDOR) {
            Vendedor vendedor = (Vendedor) usuario;
            VendedorDTO dto = new VendedorDTO();
            dto.setNombre(vendedor.getNombre());
            dto.setApellido(vendedor.getApellido());
            dto.setUsuario(vendedor.getUsuario());
            dto.setContrasena(vendedor.getContrasena());
            dto.setCorreo(vendedor.getCorreo());
            dto.setEstado(vendedor.getEstado());
            dto.setTipoPerfil(vendedor.getTipoPerfil());
            dto.setNombreTienda(vendedor.getNombreTienda());
            dto.setDireccionTienda(vendedor.getDireccionTienda());
            return dto;
        }
        return null;
    }
}
