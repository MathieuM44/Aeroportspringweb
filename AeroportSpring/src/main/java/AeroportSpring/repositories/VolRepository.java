package AeroportSpring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import AeroportSpring.model.Vol;

public interface VolRepository extends JpaRepository<Vol, Long> {
	
	@Query("select v from Vol v left join fetch v.aeroportDepart join fetch v.aeroportArrivee")
	List<Vol> findAllAeroportDepartAndAeroportArrivee();
	
	List <Vol> findAllEscale();
	
	List <Vol> findAllReservation();
	
	List <Vol> findAllCompagnieAerienneVol();
	
	List <Vol> findAllCompagnieAerienne();
	
	@Query("select v from Vol v left join fetch v.aeroportDepart join fetch v.aeroportArrivee where v.id=:id")
	Vol findAllAeroportDepartAndAeroportArriveeById(Long id);
	
	Vol findAllEscaleById(@Param("id") Long id);
	
	Vol findAllReservationById(@Param("id") Long id);
	
	Vol findAllCompagnieAerienneVolById(@Param("id") Long id);
	
	Vol findAllCompagnieAerienneById(@Param("id") Long id);
	
}
