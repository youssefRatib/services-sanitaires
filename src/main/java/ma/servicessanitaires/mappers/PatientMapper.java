package ma.servicessanitaires.mappers;

import ma.servicessanitaires.dtos.PatientDto;
import ma.servicessanitaires.dtos.RendezVousDto;
import ma.servicessanitaires.entities.Patient;
import ma.servicessanitaires.entities.RendezVous;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class PatientMapper {
    public PatientDto fromPatient(Patient patient){
        PatientDto patientDTO=new PatientDto();
        BeanUtils.copyProperties(patient,patientDTO);
        return patientDTO;
    }
    public Patient fromPatientDto(PatientDto patientDto){
        Patient patient=new Patient();
        BeanUtils.copyProperties(patientDto,patient);
        return patient;
    }

    public RendezVousDto fromRendezVous(RendezVous rendezVous){
        RendezVousDto rendezVousDto=new RendezVousDto();
        BeanUtils.copyProperties(rendezVous,rendezVousDto);
        return rendezVousDto;
    }
    public RendezVous fromRendezVousDto(RendezVousDto rendezVousDto){
        RendezVous rendezVous=new RendezVous();
        BeanUtils.copyProperties(rendezVousDto,rendezVous);
        return rendezVous;
    }

}
