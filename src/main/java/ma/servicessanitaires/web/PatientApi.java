package ma.servicessanitaires.web;

import lombok.AllArgsConstructor;
import ma.servicessanitaires.dtos.PatientDto;
import ma.servicessanitaires.exceptions.PatientNotFoundException;
import ma.servicessanitaires.services.patientService.PatientSer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class PatientApi {
    private PatientSer patientSer;
    @GetMapping("/patients")
    public List<PatientDto> patients(){
        return patientSer.listPatients();
    }
    @GetMapping("/patients/{patientId}")
    public PatientDto getPatient(@PathVariable Long patientId) throws PatientNotFoundException {
        return patientSer.getPatient(patientId);
    }
    @PostMapping("/patients")
    public PatientDto savePatient(@RequestBody PatientDto patientDto){
        System.out.println(patientDto);
        return patientSer.createPatient(patientDto);
    }
    @PutMapping("/patients/{patientId}")
    public PatientDto updatePatients(@PathVariable Long patientId, @RequestBody PatientDto patientDto){
        patientDto.setId(patientId);
        return patientSer.updatePatient(patientDto);
    }
}
