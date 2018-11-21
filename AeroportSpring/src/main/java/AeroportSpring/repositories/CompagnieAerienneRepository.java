package AeroportSpring.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import AeroportSpring.model.CompagnieAerienne;

public interface CompagnieAerienneRepository extends JpaRepository <CompagnieAerienne, Long> {

	List <CompagnieAerienne> findAllWithCompagnieAerienneVol();
	
	List <CompagnieAerienne> findAllWithCompagnieAerienneVolByNom(@Param("nom")String nom);

	Optional<CompagnieAerienne> findByNom(String nom);
}
