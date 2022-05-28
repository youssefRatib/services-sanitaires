package ma.servicessanitaires.web;

import lombok.AllArgsConstructor;
import ma.servicessanitaires.dtos.PatientDto;
import ma.servicessanitaires.dtos.RendezVousDto;
import ma.servicessanitaires.exceptions.MedecinNotFoundException;
import ma.servicessanitaires.exceptions.PatientNotFoundException;
import ma.servicessanitaires.exceptions.RendezvousNotFoundException;
import ma.servicessanitaires.services.rendezVousService.RendezVousSer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class RendezVousApi {
    private RendezVousSer rendezVousSer;
    @GetMapping("/MesRendezVous/{patientId}")
    public List<RendezVousDto> rendezVous(@PathVariable Long patientId) throws PatientNotFoundException {
        return rendezVousSer.listRendezVous(patientId);
    }
    @GetMapping("/rendezVous/{rendezVousId}")
    public RendezVousDto getRendezVous(@PathVariable Long rendezVousId) throws RendezvousNotFoundException {
        return rendezVousSer.getRendezVous(rendezVousId);
    }
    @PostMapping("/rendezVous")
    public RendezVousDto saveRendezVous(@RequestBody RendezVousDto rendezVousDto) throws PatientNotFoundException, MedecinNotFoundException {
        return rendezVousSer.createRendezVous(rendezVousDto);
    }
    @PutMapping("/rendezVous/{rendezVousId}")
    public RendezVousDto updateRendezVous(@PathVariable Long rendezVousId, @RequestBody RendezVousDto rendezVousDto) throws PatientNotFoundException, MedecinNotFoundException {
        rendezVousDto.setId(rendezVousId);
        return rendezVousSer.updateRendezVous(rendezVousDto);
    }
    @DeleteMapping("/rendezVous/{rendezVousId}")
    public void deleteCustomer(@PathVariable Long rendezVousId){
        rendezVousSer.deleteRendezVous(rendezVousId);
    }
}
