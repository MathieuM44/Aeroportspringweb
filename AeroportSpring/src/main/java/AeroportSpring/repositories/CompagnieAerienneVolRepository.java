package AeroportSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import AeroportSpring.model.CompagnieAerienneVol;
import AeroportSpring.model.CompagnieAerienneVolKey;

public interface CompagnieAerienneVolRepository extends JpaRepository<CompagnieAerienneVol, CompagnieAerienneVolKey> {

}
