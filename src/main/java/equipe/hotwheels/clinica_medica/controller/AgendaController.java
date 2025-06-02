package equipe.hotwheels.clinica_medica.controller;

import equipe.hotwheels.clinica_medica.model.Agenda;
import equipe.hotwheels.clinica_medica.service.AgendaService;
import equipe.hotwheels.clinica_medica.service.MedicoService;
import equipe.hotwheels.clinica_medica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/agendamentos")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("agendamentos", agendaService.listarTodos());
        return "agenda/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("agenda", new Agenda());
        model.addAttribute("medicos", medicoService.listarTodos());
        model.addAttribute("pacientes", pacienteService.listarTodos());
        return "agenda/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Agenda agenda) {
        agendaService.salvar(agenda);
        return "redirect:/agendamentos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        agendaService.buscarPorId(id).ifPresent(a -> model.addAttribute("agenda", a));
        model.addAttribute("medicos", medicoService.listarTodos());
        model.addAttribute("pacientes", pacienteService.listarTodos());
        return "agenda/formulario";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        agendaService.excluir(id);
        return "redirect:/agendamentos";
    }
}
