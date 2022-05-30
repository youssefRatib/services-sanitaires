package ma.servicessanitaires.dtos;

import lombok.Data;
import ma.servicessanitaires.entities.Image;
import ma.servicessanitaires.enums.Sexe;
import ma.servicessanitaires.enums.SituationFamiliale;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Data
public class PatientDto {
    private Long id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    @Enumerated(EnumType.STRING)
    private Sexe sexe;
    private String adresse;
    private String email;
    private String pwd;
    private String tel;
    @Enumerated(EnumType.STRING)
    private SituationFamiliale situationFamiliale;
    private Long imageId;
    private String nom_a_prvenir;
    private String tel_a_prevenir;
}
