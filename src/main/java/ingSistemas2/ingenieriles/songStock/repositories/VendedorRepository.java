package ingSistemas2.ingenieriles.songStock.repositories;


import ingSistemas2.ingenieriles.songStock.entidades.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {

    Vendedor findByIdUsuario(Integer idVendedor);
}
