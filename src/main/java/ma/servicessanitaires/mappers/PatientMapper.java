package ma.servicessanitaires.mappers;

import lombok.AllArgsConstructor;
import ma.servicessanitaires.dtos.ConsultationDto;
import ma.servicessanitaires.dtos.PatientDto;
import ma.servicessanitaires.dtos.RendezVousDto;
import ma.servicessanitaires.entities.*;
import ma.servicessanitaires.exceptions.MedecinNotFoundException;
import ma.servicessanitaires.exceptions.PatientNotFoundException;
import ma.servicessanitaires.exceptions.TypeConsultationNotFoundException;
import ma.servicessanitaires.repositories.MedecinRepo;
import ma.servicessanitaires.repositories.PatientRepo;
import ma.servicessanitaires.repositories.TypeConsultationRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PatientMapper {
    private PatientRepo patientRepo;
    private MedecinRepo medecinRepo;
    private TypeConsultationRepo typeConsultationRepo;
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
        rendezVousDto.setPatientId(rendezVous.getPatient().getId());
        rendezVousDto.setMedecinId(rendezVous.getMedecin().getId());
        return rendezVousDto;
    }
    public RendezVous fromRendezVousDto(RendezVousDto rendezVousDto) throws PatientNotFoundException, MedecinNotFoundException {
        RendezVous rendezVous=new RendezVous();
        BeanUtils.copyProperties(rendezVousDto,rendezVous);
        Patient patient = patientRepo.findById(rendezVousDto.getPatientId())
                .orElseThrow(() -> new PatientNotFoundException("Patient inexistant"));
        rendezVous.setPatient(patient);
        Medecin medecin = medecinRepo.findById(rendezVousDto.getMedecinId())
                .orElseThrow(() -> new MedecinNotFoundException("Medecin inexistant"));
        rendezVous.setMedecin(medecin);
        return rendezVous;
    }

    public ConsultationDto fromConsultation(Consultation consultation){
        ConsultationDto consultationDto=new ConsultationDto();
        BeanUtils.copyProperties(consultation,consultationDto);
        consultationDto.setPatientId(consultation.getPatient().getId());
        consultationDto.setMedecinId(consultation.getMedecin().getId());
        consultationDto.setTypeConsultation(consultation.getTypeConsultation().getId());
        return consultationDto;
    }
    public Consultation fromConsultationDto(ConsultationDto consultationDto) throws PatientNotFoundException, MedecinNotFoundException, TypeConsultationNotFoundException {
        Consultation consultation=new Consultation();
        BeanUtils.copyProperties(consultationDto,consultation);
        Patient patient = patientRepo.findById(consultationDto.getPatientId())
                .orElseThrow(() -> new PatientNotFoundException("Patient inexistant"));
        consultation.setPatient(patient);
        Medecin medecin = medecinRepo.findById(consultationDto.getMedecinId())
                .orElseThrow(() -> new MedecinNotFoundException("Medecin inexistant"));
        consultation.setMedecin(medecin);
        TypeConsultation typeConsultation = typeConsultationRepo.findById(consultationDto.getTypeConsultation())
                .orElseThrow(() -> new TypeConsultationNotFoundException("Medecin inexistant"));
        consultation.setTypeConsultation(typeConsultation);
        return consultation;
    }

}
