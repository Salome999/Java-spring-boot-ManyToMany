package com.example.sanitario.repository;

import com.example.sanitario.model.Paziente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PazienteRepository extends CrudRepository<Paziente, Long> {
    List<Paziente> findByNome(String nome);
    List<Paziente> findByCognome(String cognome);
    Paziente findByCf(String cf);
    List<Paziente> findByMediciNome(String medicoNome);
}
