package ma.servicessanitaires.repositories;

import ma.servicessanitaires.entities.Patient;
import ma.servicessanitaires.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepo extends JpaRepository<RendezVous,Long> {
}
