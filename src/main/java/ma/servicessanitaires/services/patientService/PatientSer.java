package ma.servicessanitaires.services.patientService;

import ma.servicessanitaires.dtos.PatientDto;
import ma.servicessanitaires.entities.Patient;
import ma.servicessanitaires.exceptions.PatientNotFoundException;

import java.util.Collection;
import java.util.List;

public interface PatientSer {
    PatientDto createPatient(PatientDto patientDto);
    PatientDto updatePatient(PatientDto patientDto);
    List<PatientDto> listPatients();
    PatientDto getPatient(Long id) throws PatientNotFoundException;
    Patient Connect(String email,String pwd);

}
