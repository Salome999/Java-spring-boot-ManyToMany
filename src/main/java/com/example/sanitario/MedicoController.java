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



@Controller
public class MedicoController {

    @Autowired
    MedicoService medicoService;

    @Autowired
    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping("/medici")
    public String medici(Model model){
        model.addAttribute("medici", medicoService.getMedici());
        return "medici/medici";
    }
  
    @GetMapping("/medici/{id}")
    public String getMedico(@PathVariable Long id, Model model) {
        model.addAttribute("medico", medicoService.getMedico(id));
        return "medici/medico";
    }

    @GetMapping("/medici/add")
    public String mediciAddForm(Medico medico, Model model) {
        model.addAttribute("medico", medico);
        return "medici/add";
    }

    @PostMapping("/medici/add")
    public String mediciAdd(@Valid Medico medico, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "medici/add";
        }
        medicoService.addMedico(medico);
        return "redirect:/medici";
    }

    @GetMapping("/medici/{id}/edit")
    public String mediciEditForm(@PathVariable Long id, Model model) {
        Medico medico = medicoService.getMedico(id);
        model.addAttribute("medico", medico);
        return "medici/edit";
    }

    @PostMapping("/medici/{id}/edit")
    public String mediciEdit(@PathVariable Long id, @Valid Medico medico, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "medici/edit";
        }
        medico.setId(id);
        medicoService.editMedico(medico);
        return "redirect:/medici";
    }

    @GetMapping("/medici/{id}/delete")
    public String deleteMedico(@PathVariable Long id) {
        medicoService.deleteMedico(id);
        return "redirect:/medici";
    }

    @GetMapping("/assegna")
    public String mostraFormAssegna(Model model) {
        model.addAttribute("medici", medicoService.getMedici());
        return "assegna";
    }

    @PostMapping("/assegna")
    public String assegnaMedico(
            @RequestParam("matricolaMedico") String matricolaMedico,
            @RequestParam("cfPaziente") String cfPaziente) {
        medicoService.assegnaMedico(matricolaMedico, cfPaziente);
        return "redirect:/";
    }

    @GetMapping("/medici/{id}/paziente")
public String getPaziente(@PathVariable Long id, Model model) {
    Medico medico = medicoService.getMedico(id);
    Paziente paziente = medicoService.getPaziente(medico);
    model.addAttribute("medico", medico);
    model.addAttribute("paziente", paziente);
    return "medici/medico-paziente";
}


@GetMapping("/singlepage")
public String singlePage(){
    return "singlepage";
}

}
