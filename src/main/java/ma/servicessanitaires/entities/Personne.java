package ma.servicessanitaires.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.servicessanitaires.enums.Sexe;
import ma.servicessanitaires.enums.SituationFamiliale;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type",length = 4)
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;
    @Enumerated(EnumType.STRING)
    private Sexe sexe;
    private String adresse;
    private String email;
    private String pwd;
    private String tel;
    @Enumerated(EnumType.STRING)
    private SituationFamiliale situationFamiliale;
    @OneToOne
    private Image image;
}
