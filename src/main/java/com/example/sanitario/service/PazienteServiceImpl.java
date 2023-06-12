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
public class PazienteServiceImpl implements PazienteService {
    @Autowired
    private PazienteRepository pazienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;



    @Override
    public List<Paziente> getPazienti() {
        return (List<Paziente>) pazienteRepository.findAll();
    }

    @Override
    public Paziente getPaziente(Long id) {
        Optional<Paziente> pazienteOptional = pazienteRepository.findById(id);
        return pazienteOptional.orElse(null);
    }

    @Override
    public Paziente addPaziente(Paziente paziente) {
        return pazienteRepository.save(paziente);
    }

    @Override
    public Paziente editPaziente(Paziente paziente) {
        return pazienteRepository.save(paziente);
    }

    @Override
    public boolean deletePaziente(Long id) {
        pazienteRepository.deleteById(id);
        return false;
    }

    @Override
    public Paziente findByMedicoName(String medico) {

        return null;
    }


}
