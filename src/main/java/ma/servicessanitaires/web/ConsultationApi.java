package ma.servicessanitaires.web;

import lombok.AllArgsConstructor;
import ma.servicessanitaires.dtos.ConsultationDto;
import ma.servicessanitaires.exceptions.MedecinNotFoundException;
import ma.servicessanitaires.exceptions.PatientNotFoundException;
import ma.servicessanitaires.exceptions.TypeConsultationNotFoundException;
import ma.servicessanitaires.services.patientService.PatientSer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class ConsultationApi {
    private PatientSer consultationSer;
    @GetMapping("/MesConsultation/{patientId}")
    public List<ConsultationDto> mesConsultations(@PathVariable Long patientId) throws PatientNotFoundException {
        return consultationSer.listConsultationsByPatient(patientId);
    }
    @GetMapping("/ConsultationByMedecin/{medecinId}")
    public List<ConsultationDto> ConsultationByMedecin(Long patientId,@PathVariable Long medecinId) throws MedecinNotFoundException, PatientNotFoundException {
        return consultationSer.listConsultationsByMedecin(patientId,medecinId);
    }
    @GetMapping("/ConsultationByType/{typeId}")
    public List<ConsultationDto> ConsultationByType(Long patientId,@PathVariable int typeId) throws TypeConsultationNotFoundException, PatientNotFoundException {
        return consultationSer.listConsultationsByType(patientId,typeId);
    }
}
