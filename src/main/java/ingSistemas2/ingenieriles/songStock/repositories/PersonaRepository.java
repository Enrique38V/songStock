package ingSistemas2.ingenieriles.songStock.repositories;


import ingSistemas2.ingenieriles.songStock.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    Persona findByIdPersona(Integer idPersona);

}
