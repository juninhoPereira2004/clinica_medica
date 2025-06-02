package equipe.hotwheels.clinica_medica.repository;

import equipe.hotwheels.clinica_medica.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}