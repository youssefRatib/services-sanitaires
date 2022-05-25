package ma.servicessanitaires.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String synthese;
    @OneToOne
    private TypeConsultation typeConsultation;
    @OneToOne
    private Medecin medecin;
    @OneToOne
    private Patient patient;
    @OneToOne
    private RendezVous rendezVous;
    @OneToOne
    private Ordonnance ordonnance;

}
