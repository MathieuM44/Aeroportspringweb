package aeroportSpringBoot.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import aeroportSpringBoot.model.Ville;

public interface VilleRepository extends JpaRepository<Ville, Long> {

	List<Ville> findAllAeroportByNom(@Param("nom") String nom);

	List<Ville> findAllAeroport();

	Optional<Ville> findByNom(String nom);

}
