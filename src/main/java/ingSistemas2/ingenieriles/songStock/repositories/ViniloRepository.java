package ingSistemas2.ingenieriles.songStock.repositories;

import ingSistemas2.ingenieriles.songStock.entidades.Vinilo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ViniloRepository extends JpaRepository<Vinilo, Integer> {
}
