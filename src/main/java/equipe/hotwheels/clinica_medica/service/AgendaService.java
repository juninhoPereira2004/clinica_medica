package equipe.hotwheels.clinica_medica.service;

import equipe.hotwheels.clinica_medica.model.Agenda;
import equipe.hotwheels.clinica_medica.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    public List<Agenda> listarTodos() {
        return agendaRepository.findAll();
    }

    public void salvar(Agenda agenda) {
        agendaRepository.save(agenda);
    }

    public Optional<Agenda> buscarPorId(Long id) {
        return agendaRepository.findById(id);
    }

    public void excluir(Long id) {
        agendaRepository.deleteById(id);
    }
}
