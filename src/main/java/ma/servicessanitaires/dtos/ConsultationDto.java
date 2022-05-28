package ma.servicessanitaires.dtos;

import lombok.Data;
import ma.servicessanitaires.entities.Ordonnance;
import ma.servicessanitaires.entities.TypeConsultation;

import java.util.Date;

@Data
public class ConsultationDto {
    private Long id;
    private Date date;
    private String synthese;
    private TypeConsultation typeConsultation;
    private Long medecinId;
    private Long patientId;
    private Long rendezVousId;
    private Ordonnance ordonnance;
}
