package ma.servicessanitaires.services.patientService;

import ma.servicessanitaires.entities.Patient;

import java.util.Collection;

public interface PatientSer {
    Patient create(Patient patient);
    Patient update(Patient patient);
    Boolean delete(Long id);
    Collection<Patient> list(int limit);
    Patient get(Long id);
    Patient Connect(String email,String pwd);

}
