package ma.servicessanitaires.services.rendezVousService;

import groovy.util.logging.Slf4j;
import lombok.AllArgsConstructor;
import ma.servicessanitaires.dtos.PatientDto;
import ma.servicessanitaires.dtos.RendezVousDto;
import ma.servicessanitaires.entities.Patient;
import ma.servicessanitaires.entities.RendezVous;
import ma.servicessanitaires.exceptions.RendezvousNotFoundException;
import ma.servicessanitaires.mappers.PatientMapper;
import ma.servicessanitaires.repositories.PatientRepo;
import ma.servicessanitaires.repositories.RendezVousRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Transactional
@Slf4j
public class RendezVousSerImpl implements RendezVousSer {
    private RendezVousRepo rendezVousRepo;
    private PatientMapper patientMapper;
    @Override
    public RendezVousDto createRendezVous(RendezVousDto rendezVousDto) {
        RendezVous rendezVous = patientMapper.fromRendezVousDto(rendezVousDto);
        return patientMapper.fromRendezVous(rendezVousRepo.save(rendezVous));
    }

    @Override
    public RendezVousDto updateRendezVous(RendezVousDto rendezVousDto) {
        RendezVous rendezVous = patientMapper.fromRendezVousDto(rendezVousDto);
        return patientMapper.fromRendezVous(rendezVousRepo.save(rendezVous));
    }

    @Override
    public void deleteRendezVous(Long id) {
        rendezVousRepo.deleteById(id);
    }

    @Override
    public List<RendezVousDto> listRendezVous() {
        List<RendezVous> rendezVousList = rendezVousRepo.findAll();
        List<RendezVousDto> rendezVousDtoList = rendezVousList.stream()
                .map(rendezVous -> patientMapper.fromRendezVous(rendezVous))
                .collect(Collectors.toList());
        return rendezVousDtoList;
    }

    @Override
    public RendezVousDto getRendezVous(Long id) throws RendezvousNotFoundException {
        RendezVous rendezVous = rendezVousRepo.findById(id)
                .orElseThrow(() -> new RendezvousNotFoundException("Rendez-vous inexistant"));
        return patientMapper.fromRendezVous(rendezVous);
    }
}
