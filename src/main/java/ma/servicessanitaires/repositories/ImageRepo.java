package ma.servicessanitaires.repositories;

import ma.servicessanitaires.entities.Image;import ma.servicessanitaires.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepo extends JpaRepository<Image,Long> {
    Optional<Image> findByName(String name);
}
