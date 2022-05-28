package ma.servicessanitaires.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class ConsultationDto {
    private Long id;
    private Date date;
    private String synthese;
    private int typeConsultation;
    private Long medecinId;
    private Long patientId;
    private Long rendezVousId;
    private Long ordonnanceId;
}
