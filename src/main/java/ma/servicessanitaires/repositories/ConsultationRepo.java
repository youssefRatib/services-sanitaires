package ma.servicessanitaires.repositories;

import ma.servicessanitaires.entities.Consultation;
import ma.servicessanitaires.entities.Medecin;
import ma.servicessanitaires.entities.Patient;
import ma.servicessanitaires.entities.TypeConsultation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultationRepo extends JpaRepository<Consultation,Long> {
    List<Consultation> findAllByPatient(Patient patient);
    List<Consultation> findAllByPatientAndMedecin(Patient patient,Medecin medecin);
    List<Consultation> findAllByPatientAndTypeConsultation(Patient patient,TypeConsultation typeConsultation);
}


