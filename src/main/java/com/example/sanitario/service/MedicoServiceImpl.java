package com.example.sanitario.service;

import com.example.sanitario.model.Medico;

import com.example.sanitario.model.Paziente;
import com.example.sanitario.repository.MedicoRepository;
import com.example.sanitario.repository.PazienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoServiceImpl implements MedicoService {
     @Autowired
     private MedicoRepository medicoRepository;

     @Autowired
     private PazienteRepository pazienteRepository;

  

    @Autowired
    public MedicoServiceImpl(MedicoRepository medicoRepository, PazienteRepository pazienteRepository) {
        this.medicoRepository = medicoRepository;
        this.pazienteRepository = pazienteRepository;
    }


    @Override
    public List<Medico> getMedici() {
        return (List<Medico>) medicoRepository.findAll();
    }



 @Override
    public Medico getMedico(Long id)  {
        Optional<Medico> medicoOptional = medicoRepository.findById(id);
        return medicoRepository.findById(id).get();
    }
  

    @Override
    public Medico addMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    @Override
    public Medico editMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    @Override
    public boolean deleteMedico(Long id) {
        return false;
    }

    @Override
    public void assegnaMedico(String matricolaMedico, String cfPaziente) {
        Medico medico = medicoRepository.findByMatricola(matricolaMedico);
        Paziente paziente = pazienteRepository.findByCf(cfPaziente);

        if (medico != null && paziente != null) {
            medico.getPazienti().add(paziente);
            paziente.getMedici().add(medico);
            medicoRepository.save(medico);
            pazienteRepository.save(paziente);
        }
    }
    

    @Override
public Paziente getPaziente(Medico medico) {
    List<Paziente> pazienti = medico.getPazienti();
    if (!pazienti.isEmpty()) {
        return pazienti.get(0); 
    }
    return null; 
}


}

