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

    public Usuario helperUsuarioDTOsToEntity(UsuarioDTO usuarioDTO){
        Usuario usuario;
        if (usuarioDTO.getTipoPerfil() == TipoPerfil.VENDEDOR) {
            usuario = new Vendedor();
        } else {
            usuario = new Comprador();
        }
        usuario.setIdUsuario(usuarioDTO.getIdUsuario()!=null?usuarioDTO.getIdUsuario():null);
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setApellido(usuarioDTO.getApellido());
        usuario.setUsuario(usuarioDTO.getUsuario());
        usuario.setContrasena(usuarioDTO.getContrasena());
        usuario.setCorreo(usuarioDTO.getCorreo());
        usuario.setEstado(usuarioDTO.getEstado());
        usuario.setTipoPerfil(usuarioDTO.getTipoPerfil());
        return usuario;
    }

    public Usuario helperUsuarioDTOToEntity(UsuarioDTO usuarioDTO){
        try {
            if (usuarioDTO.getTipoPerfil() == TipoPerfil.COMPRADOR) {
                Comprador comprador = new Comprador();
                CompradorDTO compradorDTO = new CompradorDTO();
                comprador.setNombre(usuarioDTO.getNombre());
                comprador.setApellido(usuarioDTO.getApellido());
                comprador.setUsuario(usuarioDTO.getUsuario());
                comprador.setContrasena(usuarioDTO.getContrasena());
                comprador.setCorreo(usuarioDTO.getCorreo());
                comprador.setEstado(usuarioDTO.getEstado());
                comprador.setTipoPerfil(usuarioDTO.getTipoPerfil());
                comprador.setDireccion(compradorDTO.getDireccion());
                comprador.setTelefono(compradorDTO.getTelefono());
                return comprador;
            } else if (usuarioDTO.getTipoPerfil() == TipoPerfil.VENDEDOR) {
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
        }catch (Exception ex){
            System.out.println("ERROR: " + ex);
        }
        return null;
    }

    public UsuarioDTO helperUsuarioEntitysToDTO(Usuario usuario){
        System.out.println("ENTRO EN EL FUCKING HELPER");
        System.out.println(usuario.getTipoPerfil());
        UsuarioDTO usu;
        if (usuario.getTipoPerfil() == TipoPerfil.VENDEDOR) {
            usu = new VendedorDTO();
        } else {
            usu = new CompradorDTO();
        }
        usu.setIdUsuario(usuario.getIdUsuario());
        usu.setNombre(usuario.getNombre());
        usu.setApellido(usuario.getApellido());
        usu.setUsuario(usuario.getUsuario());
        usu.setContrasena(usuario.getContrasena());
        usu.setCorreo(usuario.getCorreo());
        usu.setEstado(usuario.getEstado());
        usu.setTipoPerfil(usuario.getTipoPerfil());
        return usu;
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
