package ma.servicessanitaires.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;
    private String sexe;
    private String adresse;
    private String email;
    private String pwd;
    private String tel;
    private String situationFamiliale;
    private String imgUrl;
}
