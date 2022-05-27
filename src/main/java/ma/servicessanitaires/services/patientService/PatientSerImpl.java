package ma.servicessanitaires.services.patientService;

import groovy.util.logging.Log;
import groovy.util.logging.Log4j;
import groovy.util.logging.Slf4j;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import ma.servicessanitaires.dtos.PatientDto;
import ma.servicessanitaires.entities.Patient;
import ma.servicessanitaires.entities.RendezVous;
import ma.servicessanitaires.exceptions.PatientNotFoundException;
import ma.servicessanitaires.exceptions.RendezvousNotFoundException;
import ma.servicessanitaires.mappers.PatientMapper;
import ma.servicessanitaires.repositories.PatientRepo;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.Servlet;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static org.springframework.data.domain.PageRequest.*;

@AllArgsConstructor
@Service
@Transactional
@Slf4j
public class PatientSerImpl implements PatientSer {
    private PatientRepo patientRepo;
    private PatientMapper patientMapper;

    @Override
    public PatientDto createPatient(PatientDto patientDto) {
        patientDto.setImgUrl(setPatientImgUrl());
        Patient patient = patientMapper.fromPatientDto(patientDto);
        return patientMapper.fromPatient(patientRepo.save(patient));
    }

    private String setPatientImgUrl() {
        String imgNames = "logo_main.png";
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/patient/img/"+imgNames).toUriString();
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
}
