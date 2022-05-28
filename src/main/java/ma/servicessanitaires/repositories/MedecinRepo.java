package ma.servicessanitaires.repositories;

import ma.servicessanitaires.entities.Medecin;
import ma.servicessanitaires.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepo extends JpaRepository<Medecin,Long> {
}
