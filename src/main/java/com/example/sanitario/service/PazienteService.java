package com.example.sanitario.service;

import com.example.sanitario.model.Medico;
import com.example.sanitario.model.Paziente;

import java.util.List;

public interface PazienteService {
    List<Paziente> getPazienti();
    Paziente getPaziente(Long id);
    Paziente addPaziente(Paziente paziente);
    Paziente editPaziente(Paziente paziente);
    boolean deletePaziente(Long id);
    Paziente findByMedicoName(String medico);
}
