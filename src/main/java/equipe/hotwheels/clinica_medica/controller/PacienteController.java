package equipe.hotwheels.clinica_medica.controller;

import equipe.hotwheels.clinica_medica.model.Paciente;
import equipe.hotwheels.clinica_medica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("pacientes", pacienteService.listarTodos());
        return "paciente/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "paciente/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Paciente paciente) {
        pacienteService.salvar(paciente);
        return "redirect:/pacientes";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        pacienteService.buscarPorId(id).ifPresent(p -> model.addAttribute("paciente", p));
        return "paciente/formulario";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        pacienteService.excluir(id);
        return "redirect:/pacientes";
    }
}
