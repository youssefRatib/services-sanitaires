package ma.servicessanitaires.services.patientService;

import groovy.util.logging.Log;
import groovy.util.logging.Log4j;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import ma.servicessanitaires.entities.Patient;
import ma.servicessanitaires.repositories.PatientRepo;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.Servlet;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.logging.Logger;

import static org.springframework.data.domain.PageRequest.*;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
@Log4j
public class PatientSerImpl implements PatientSer {
    private final PatientRepo patientRepo;
    @Override
    public Patient create(Patient patient) {
        patient.setImgUrl(setPatientImgUrl());
        return patientRepo.save(patient);
    }

    private String setPatientImgUrl() {
        String imgNames = "logo_main.png";
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/patient/img/"+imgNames).toUriString();
    }

    @Override
    public Patient update(Patient patient) {
        return patientRepo.save(patient);
    }

    @Override
    public Boolean delete(Long id) {
        patientRepo.deleteById(id);
        return true;
    }

    @Override
    public Collection<Patient> list(int limit) {
        return patientRepo.findAll(of(0,limit)).toList();
    }

    @Override
    public Patient get(Long id) {
        return patientRepo.findById(id).get();
    }

    @Override
    public Patient Connect(String email, String pwd) {
        return patientRepo.findByEmailAndPwd(email,pwd);
    }
}
