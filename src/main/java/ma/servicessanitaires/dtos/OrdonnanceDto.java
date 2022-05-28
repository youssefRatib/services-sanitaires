package ma.servicessanitaires.dtos;

import lombok.Data;
import ma.servicessanitaires.entities.Medicament;

import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.List;

@Data
public class OrdonnanceDto {
    private Long id;
    private String description;
    private List<MedicamentDto> medicaments;
}
