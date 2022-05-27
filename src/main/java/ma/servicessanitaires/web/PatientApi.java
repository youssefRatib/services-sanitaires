package ma.servicessanitaires.web;

import lombok.AllArgsConstructor;
import ma.servicessanitaires.dtos.PatientDto;
import ma.servicessanitaires.entities.Patient;
import ma.servicessanitaires.exceptions.PatientNotFoundException;
import ma.servicessanitaires.services.patientService.PatientSer;
import ma.servicessanitaires.services.patientService.PatientSerImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class PatientApi {
    private PatientSer patientSer;
    @GetMapping("/patients")
    public List<PatientDto> customers(){
        return patientSer.listPatients();
    }
    @GetMapping("/patients/{patientid}")
    public PatientDto getPatient(Long id) throws PatientNotFoundException {
        return patientSer.getPatient(id);
    }
    @PostMapping("/patients")
    public PatientDto savePatient(@RequestBody PatientDto patientDto){
        return patientSer.createPatient(patientDto);
    }
    @PutMapping("/patients/{patientId}")
    public PatientDto updateCustomer(@PathVariable Long patientId, @RequestBody PatientDto patientDto){
        patientDto.setId(patientId);
        return patientSer.updatePatient(patientDto);
    }
}
