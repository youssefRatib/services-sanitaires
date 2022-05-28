package ma.servicessanitaires.services.rendezVousService;

import ma.servicessanitaires.dtos.PatientDto;
import ma.servicessanitaires.dtos.RendezVousDto;
import ma.servicessanitaires.entities.Patient;
import ma.servicessanitaires.exceptions.MedecinNotFoundException;
import ma.servicessanitaires.exceptions.PatientNotFoundException;
import ma.servicessanitaires.exceptions.RendezvousNotFoundException;

import java.util.List;

public interface RendezVousSer {
    RendezVousDto createRendezVous(RendezVousDto rendezVousDto) throws PatientNotFoundException, MedecinNotFoundException;
    RendezVousDto updateRendezVous(RendezVousDto rendezVousDto) throws PatientNotFoundException, MedecinNotFoundException;
    void deleteRendezVous(Long id);
    List<RendezVousDto> listRendezVous(Long patientId) throws PatientNotFoundException;
    RendezVousDto getRendezVous(Long id) throws RendezvousNotFoundException;
}
