package ingSistemas2.ingenieriles.songStock.repositories;

import ingSistemas2.ingenieriles.songStock.entidades.Comprador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompradorRepository extends JpaRepository<Comprador, Integer> {
}
