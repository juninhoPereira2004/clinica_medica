package equipe.hotwheels.clinica_medica.service;

import equipe.hotwheels.clinica_medica.model.Medico;
import equipe.hotwheels.clinica_medica.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public List<Medico> listarTodos() {
        return medicoRepository.findAll();
    }

    public void salvar(Medico medico) {
        medicoRepository.save(medico);
    }

    public Optional<Medico> buscarPorId(Long id) {
        return medicoRepository.findById(id);
    }

    public void excluir(Long id) {
        medicoRepository.deleteById(id);
    }
}
