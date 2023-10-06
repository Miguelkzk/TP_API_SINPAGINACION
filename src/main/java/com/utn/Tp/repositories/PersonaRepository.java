package com.utn.Tp.repositories;

import com.utn.Tp.entities.Persona;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonaRepository extends BaseRepository<Persona,Long> {
}
