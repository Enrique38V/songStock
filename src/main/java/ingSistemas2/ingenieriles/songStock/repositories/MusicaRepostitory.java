package ingSistemas2.ingenieriles.songStock.repositories;

import ingSistemas2.ingenieriles.songStock.entidades.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicaRepostitory extends JpaRepository<Musica, Integer> {
}
