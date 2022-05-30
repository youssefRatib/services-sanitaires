package ma.servicessanitaires.services.patientService;

import groovy.util.logging.Log;
import groovy.util.logging.Log4j;
import groovy.util.logging.Slf4j;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import ma.servicessanitaires.dtos.ConsultationDto;
import ma.servicessanitaires.dtos.PatientDto;
import ma.servicessanitaires.entities.*;
import ma.servicessanitaires.exceptions.MedecinNotFoundException;
import ma.servicessanitaires.exceptions.PatientNotFoundException;
import ma.servicessanitaires.exceptions.RendezvousNotFoundException;
import ma.servicessanitaires.exceptions.TypeConsultationNotFoundException;
import ma.servicessanitaires.mappers.PatientMapper;
import ma.servicessanitaires.repositories.ConsultationRepo;
import ma.servicessanitaires.repositories.MedecinRepo;
import ma.servicessanitaires.repositories.PatientRepo;
import ma.servicessanitaires.repositories.TypeConsultationRepo;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.Servlet;
import javax.transaction.Transactional;
import java.io.Console;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
@Transactional
@Slf4j
public class PatientSerImpl implements PatientSer {
    private PatientRepo patientRepo;
    private MedecinRepo medecinRepo;
    private TypeConsultationRepo typeConsultationRepo;
    private ConsultationRepo consultationRepo;
    private PatientMapper patientMapper;

    @Override
    public PatientDto createPatient(PatientDto patientDto) {
        System.out.println(patientDto);
        Patient patient = patientMapper.fromPatientDto(patientDto);
        return patientMapper.fromPatient(patientRepo.save(patient));
    }


    @Override
    public PatientDto updatePatient(PatientDto patientDto) {
        Patient patient = patientMapper.fromPatientDto(patientDto);
        return patientMapper.fromPatient(patientRepo.save(patient));
    }

    @Override
    public List<PatientDto> listPatients() {
        List<Patient> patients = patientRepo.findAll();
        List<PatientDto> patientsDto = patients.stream()
                .map(patient -> patientMapper.fromPatient(patient))
                .collect(Collectors.toList());
        return patientsDto;
    }

    @Override
    public PatientDto getPatient(Long id) throws PatientNotFoundException {
        Patient patient = patientRepo.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("Patient inexistant"));
        return patientMapper.fromPatient(patient) ;
    }

    @Override
    public Patient Connect(String email, String pwd) {
        return patientRepo.findByEmailAndPwd(email,pwd);
    }

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
