package ma.servicessanitaires.repositories;

import ma.servicessanitaires.dtos.RendezVousDto;
import ma.servicessanitaires.entities.Patient;
import ma.servicessanitaires.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RendezVousRepo extends JpaRepository<RendezVous,Long> {
    List<RendezVous> findAllByPatient(Patient patient);
}
