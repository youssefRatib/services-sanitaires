package ma.servicessanitaires.dtos;


import lombok.Data;


@Data
public class TraitementUsageDto {
    private Long id;
    private int nombreUsageParJour;
    private Boolean apresManger;
    private Boolean complet;
    private String dosage;
}
