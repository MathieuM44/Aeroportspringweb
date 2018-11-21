package AeroportSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import AeroportSpring.model.VilleAeroport;
import AeroportSpring.model.VilleAeroportKey;

public interface VilleAeroportRepository extends JpaRepository<VilleAeroport, VilleAeroportKey> {

}
