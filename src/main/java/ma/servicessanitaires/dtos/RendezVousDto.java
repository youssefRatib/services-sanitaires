package ma.servicessanitaires.dtos;

import lombok.Data;
import ma.servicessanitaires.enums.RendezVousStatus;
import ma.servicessanitaires.entities.Medecin;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;
@Data
public class RendezVousDto {
    private Long id;
    private Date date;
    @Enumerated(EnumType.STRING)
    private RendezVousStatus status;
    private Long medecinId;
    private Long patientId;
}
