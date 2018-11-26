package aeroportSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import aeroportSpringBoot.model.CompagnieAerienneVol;
import aeroportSpringBoot.model.CompagnieAerienneVolKey;

public interface CompagnieAerienneVolRepository extends JpaRepository<CompagnieAerienneVol, CompagnieAerienneVolKey> {

}
