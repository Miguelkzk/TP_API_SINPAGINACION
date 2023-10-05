package com.utn.Tp.servicies;

import com.utn.Tp.entities.Persona;
import com.utn.Tp.repositories.BaseRepository;
import com.utn.Tp.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Long> implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository) {
        super(baseRepository);
    }
}
