package ingSistemas2.ingenieriles.songStock.repositories;

import ingSistemas2.ingenieriles.songStock.entidades.ListaReproduccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListaReproduccionRepository extends JpaRepository<ListaReproduccion, Integer> {

    ListaReproduccion findByIdLista(Integer idLista);

    @Query(value = "SELECT * FROM listareproduccion where idComprador = :idComprador", nativeQuery = true)
    List<ListaReproduccion> consultarListas(@Param("idComprador")Integer idComprador);
}
