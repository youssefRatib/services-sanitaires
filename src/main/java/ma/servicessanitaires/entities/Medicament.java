package ma.servicessanitaires.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medicament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Column(unique = true)
    private String nomCommercial;
    private Double prix;
    private Double mesure;
    @Column(length = 3)
    private String uniteDeMesure;
    private String description;
    private String urlImg;
    private String forme;
    private String effetsSecondaires;
    @ManyToMany
    private List<TraitementUsage> traitementUsages;

}
