package ma.servicessanitaires.entities;

import ma.servicessanitaires.enums.RendezVousStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    @Enumerated(EnumType.STRING)
    private RendezVousStatus status;
    @OneToOne
    private Medecin medecin;
    @OneToOne
    private Patient patient;
}
