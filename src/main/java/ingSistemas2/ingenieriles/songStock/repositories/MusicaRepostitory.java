package ingSistemas2.ingenieriles.songStock.repositories;

import ingSistemas2.ingenieriles.songStock.entidades.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicaRepostitory extends JpaRepository<Musica, Integer> {

    Musica findByIdMusica(Integer idMusica);

    @Query(value = "SELECT * FROM musica where idVendedor = :idVendedor  ", nativeQuery = true)
    List<Musica> consultaMusicaVendedor(@Param("idVendedor")Integer idVendedor);

    @Query(value = "SELECT m.* FROM musica m\n" +
            " JOIN  musicacomprada mp ON mp.idMusica = m.idMusica\n" +
            " JOIN comprador c ON c.idComprador = mp.idComprador\n" +
            " WHERE c.idComprador = :idComprador", nativeQuery = true)
    List<Musica> consultaMusicaComprador(@Param("idComprador")Integer idComprador);
}
