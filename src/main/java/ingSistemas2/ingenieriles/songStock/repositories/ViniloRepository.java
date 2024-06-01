package ingSistemas2.ingenieriles.songStock.repositories;


import ingSistemas2.ingenieriles.songStock.entidades.Vinilo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ViniloRepository extends JpaRepository<Vinilo, Integer> {

    Vinilo findByIdVinilo(Integer idVinilo);

    @Query(value = "SELECT * FROM vinilo where idVendedor = :idVendedor  ", nativeQuery = true)
    List<Vinilo> consultaViniloVendedor(@Param("idVendedor")Integer idVendedor);
}
