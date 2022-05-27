package ma.servicessanitaires.services.rendezVousService;

import ma.servicessanitaires.dtos.PatientDto;
import ma.servicessanitaires.dtos.RendezVousDto;
import ma.servicessanitaires.entities.Patient;
import ma.servicessanitaires.exceptions.RendezvousNotFoundException;

import java.util.List;

public interface RendezVousSer {
    RendezVousDto createRendezVous(RendezVousDto rendezVousDto);
    RendezVousDto updateRendezVous(RendezVousDto rendezVousDto);
    void deleteRendezVous(Long id);
    List<RendezVousDto> listRendezVous();
    RendezVousDto getRendezVous(Long id) throws RendezvousNotFoundException;
}
