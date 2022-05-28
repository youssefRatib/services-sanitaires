package ma.servicessanitaires.services.ConsultationService;

import ma.servicessanitaires.dtos.ConsultationDto;
import ma.servicessanitaires.entities.*;
import ma.servicessanitaires.exceptions.MedecinNotFoundException;
import ma.servicessanitaires.exceptions.PatientNotFoundException;
import ma.servicessanitaires.exceptions.TypeConsultationNotFoundException;
import ma.servicessanitaires.mappers.PatientMapper;
import ma.servicessanitaires.repositories.ConsultationRepo;
import ma.servicessanitaires.repositories.MedecinRepo;
import ma.servicessanitaires.repositories.PatientRepo;
import ma.servicessanitaires.repositories.TypeConsultationRepo;

import java.util.List;
import java.util.stream.Collectors;

public class ConsultationSerImpl implements ConsultationSer {
    private PatientRepo patientRepo;
    private MedecinRepo medecinRepo;
    private ConsultationRepo consultationRepo;
    private TypeConsultationRepo typeConsultationRepo;
    private PatientMapper patientMapper;
    @Override
    public List<ConsultationDto> listConsultationsByPatient(Long patientId) throws PatientNotFoundException {
        Patient patient = patientRepo.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException("Patient inexistant"));
        List<Consultation> consultationList = consultationRepo.findAllByPatient(patient);
        List<ConsultationDto> consultationDtoList = consultationList.stream()
                .map(consultation -> patientMapper.fromConsultation(consultation))
                .collect(Collectors.toList());
        return consultationDtoList;
    }

    @Override
    public List<ConsultationDto> listConsultationsByMedecin(Long patientId,Long medecinId) throws MedecinNotFoundException, PatientNotFoundException {
        Patient patient = patientRepo.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException("Patient inexistant"));
        Medecin medecin = medecinRepo.findById(medecinId)
                .orElseThrow(() -> new MedecinNotFoundException("Medecin inexistant"));
        List<Consultation> consultationList = consultationRepo.findAllByPatientAndMedecin(patient,medecin);
        List<ConsultationDto> consultationDtoList = consultationList.stream()
                .map(consultation -> patientMapper.fromConsultation(consultation))
                .collect(Collectors.toList());
        return consultationDtoList;
    }

    @Override
    public List<ConsultationDto> listConsultationsByType(Long patientId,int typeId) throws TypeConsultationNotFoundException, PatientNotFoundException {
        Patient patient = patientRepo.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException("Patient inexistant"));
        TypeConsultation typeConsultation = typeConsultationRepo.findById(typeId)
                .orElseThrow(() -> new TypeConsultationNotFoundException("Type consultation inexistant"));
        List<Consultation> consultationList = consultationRepo.findAllByPatientAndTypeConsultation(patient,typeConsultation);
        List<ConsultationDto> consultationDtoList = consultationList.stream()
                .map(consultation -> patientMapper.fromConsultation(consultation))
                .collect(Collectors.toList());
        return consultationDtoList;
    }
}