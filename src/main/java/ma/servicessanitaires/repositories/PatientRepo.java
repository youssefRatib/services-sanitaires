package ma.servicessanitaires.repositories;

import ma.servicessanitaires.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient,Long> {
    Patient findByEmailAndPwd(String email,String pwd);
}
