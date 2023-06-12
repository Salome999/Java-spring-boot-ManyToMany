package com.example.sanitario;

import com.example.sanitario.model.Medico;
import com.example.sanitario.model.Paziente;
import com.example.sanitario.service.MedicoService;
import com.example.sanitario.service.PazienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class PazienteController {
    private final MedicoService medicoService;
    private final PazienteService pazienteService;

    @Autowired
    public PazienteController(MedicoService medicoService, PazienteService pazienteService) {
        this.medicoService = medicoService;
        this.pazienteService = pazienteService;
    }

    @ModelAttribute
    public void commonAttributes(Model model) {
        model.addAttribute("medici", medicoService.getMedici());
    }


    @GetMapping("/pazienti")
    public String pazienti(Model model){
        model.addAttribute("pazienti", pazienteService.getPazienti());
        return "pazienti/pazienti";
    }

    @GetMapping("/pazienti/{id}")
    public String getPaziente(@PathVariable Long id, Model model) {
        model.addAttribute("paziente", pazienteService.getPaziente(id));
        return "pazienti/paziente";
    }

    @GetMapping("/pazienti/add")
    public String pazientiAddForm(Paziente paziente, Model model) {
        model.addAttribute("paziente", paziente);
        return "pazienti/add";
    }

    @PostMapping("/pazienti/add")
    public String pazientiAdd(@Valid Paziente paziente, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "pazienti/add";
        }
        pazienteService.addPaziente(paziente);
        return "redirect:/pazienti";
    }

    @GetMapping("/pazienti/{id}/edit")
    public String pazientiEditForm(@PathVariable Long id, Model model) {
        Paziente paziente = pazienteService.getPaziente(id);
        model.addAttribute("paziente", paziente);
        return "pazienti/edit";
    }

    @PostMapping("/pazienti/{id}/edit")
    public String pazientiEdit(@PathVariable Long id, @Valid Paziente paziente, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "pazienti/edit";
        }
        paziente.setId(id);
        pazienteService.editPaziente(paziente);
        return "redirect:/pazienti";
    }

    @GetMapping("/pazienti/{id}/delete")
    public String deletePaziente(@PathVariable Long id) {
        pazienteService.deletePaziente(id);
        return "redirect:/pazienti";
    }


    
}
