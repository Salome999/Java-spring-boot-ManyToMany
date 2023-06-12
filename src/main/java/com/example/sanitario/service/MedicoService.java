package com.example.sanitario.service;
import com.example.sanitario.model.Medico;
import com.example.sanitario.model.Paziente;

import java.util.List;

public interface MedicoService {
    List<Medico> getMedici();
    Medico getMedico(Long id);
    Medico addMedico(Medico medico);
    Medico editMedico(Medico medico);
    boolean deleteMedico(Long id);
    void assegnaMedico(String matricolaMedico, String cfPaziente);
    Paziente getPaziente(Medico medico);

}
