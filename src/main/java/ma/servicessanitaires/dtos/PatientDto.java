package ma.servicessanitaires.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class PatientDto {
    private Long id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String sexe;
    private String adresse;
    private String email;
    private String pwd;
    private String tel;
    private String situationFamiliale;
    private String imgUrl;
    private String nom_a_prvenir;
    private String tel_a_prevenir;
}
