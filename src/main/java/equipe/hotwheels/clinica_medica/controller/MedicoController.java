package equipe.hotwheels.clinica_medica.controller;

import equipe.hotwheels.clinica_medica.model.Medico;
import equipe.hotwheels.clinica_medica.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("medicos", medicoService.listarTodos());
        return "medico/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("medico", new Medico());
        return "medico/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Medico medico) {
        medicoService.salvar(medico);
        return "redirect:/medicos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        medicoService.buscarPorId(id).ifPresent(m -> model.addAttribute("medico", m));
        return "medico/formulario";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        medicoService.excluir(id);
        return "redirect:/medicos";
    }
}
