package equipe.hotwheels.clinica_medica.service;

import equipe.hotwheels.clinica_medica.model.Paciente;
import equipe.hotwheels.clinica_medica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> listarTodos() {
        return pacienteRepository.findAll();
    }

    public void salvar(Paciente paciente) {
        pacienteRepository.save(paciente);
    }

    public Optional<Paciente> buscarPorId(Long id) {
        return pacienteRepository.findById(id);
    }

    public void excluir(Long id) {
        pacienteRepository.deleteById(id);
    }
}
