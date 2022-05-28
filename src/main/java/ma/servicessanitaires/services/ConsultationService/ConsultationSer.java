package ma.servicessanitaires.services.ConsultationService;

import ma.servicessanitaires.dtos.ConsultationDto;
import ma.servicessanitaires.exceptions.MedecinNotFoundException;
import ma.servicessanitaires.exceptions.PatientNotFoundException;
import ma.servicessanitaires.exceptions.TypeConsultationNotFoundException;

import java.util.List;

public interface ConsultationSer {
    List<ConsultationDto> listConsultationsByPatient(Long patientId) throws PatientNotFoundException;
    List<ConsultationDto> listConsultationsByMedecin(Long patientId,Long medecinId) throws PatientNotFoundException, MedecinNotFoundException;
    List<ConsultationDto> listConsultationsByType(Long patientId,int typeId) throws TypeConsultationNotFoundException, PatientNotFoundException;
}