package AeroportSpring.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import AeroportSpring.model.Aeroport;

public interface AeroportRepository extends JpaRepository<Aeroport, Long> {

	@Query("select a from Aeroport a left join fetch a.volsDepart join fetch a.volsArrivee")
	List<Aeroport> findAllWithVolsDepartAndVolsArrivee();
	
	List<Aeroport> findAllEscale();
	
	List<Aeroport> findAllVille();
	
	@Query("select a from Aeroport a left join fetch a.volsDepart join fetch a.volsArrivee where a.nom=:nom")
	Aeroport findVolsDepartAndVolsArriveeByNom(@Param("nom") String nom);
	
	Aeroport findAllEscaleByNom(@Param("nom") String nom);
	
	Aeroport findAllVilleByNom(@Param("nom") String nom);

	Optional<Aeroport> findByNom(String nom);
	
}
