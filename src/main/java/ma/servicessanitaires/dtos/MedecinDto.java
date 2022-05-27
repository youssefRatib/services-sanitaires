package ma.servicessanitaires.dtos;

import ma.servicessanitaires.entities.Specialite;

import java.util.Date;

public class MedecinDto {
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
    private Specialite specialite;
}
