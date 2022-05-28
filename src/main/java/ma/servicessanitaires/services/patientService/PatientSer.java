package ma.servicessanitaires.services.patientService;

import ma.servicessanitaires.dtos.ConsultationDto;
import ma.servicessanitaires.dtos.PatientDto;
import ma.servicessanitaires.entities.Patient;
import ma.servicessanitaires.exceptions.MedecinNotFoundException;
import ma.servicessanitaires.exceptions.PatientNotFoundException;
import ma.servicessanitaires.exceptions.TypeConsultationNotFoundException;

import java.util.Collection;
import java.util.List;

public interface PatientSer {
    PatientDto createPatient(PatientDto patientDto);
    PatientDto updatePatient(PatientDto patientDto);
    List<PatientDto> listPatients();
    PatientDto getPatient(Long id) throws PatientNotFoundException;
    Patient Connect(String email,String pwd);

    List<ConsultationDto> listConsultationsByPatient(Long patientId) throws PatientNotFoundException;
    List<ConsultationDto> listConsultationsByMedecin(Long patientId,Long medecinId) throws PatientNotFoundException, MedecinNotFoundException;
    List<ConsultationDto> listConsultationsByType(Long patientId,int typeId) throws TypeConsultationNotFoundException, PatientNotFoundException;




}
