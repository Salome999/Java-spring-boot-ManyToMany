package com.example.sanitario.repository;

import com.example.sanitario.model.Medico;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MedicoRepository extends CrudRepository<Medico, Long> {
    List<Medico> findByNome(String nome);
    List<Medico> findByCognome(String cognome);
    List<Medico> findByCf(String cf);
    Medico findByMatricola(String matricola);
    List<Medico> findByPazientiNome(String pazienteNome);
}
