package AeroportSpring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AeroportSpring.model.CompagnieAerienne;
import AeroportSpring.repositories.CompagnieAerienneRepository;

@Service
public class CompagnieAerienneService {

	@Autowired
	private CompagnieAerienneRepository compagnieAerienneRepository;

	// methodes
	
	public void trouverCompagnieAerienneVol (String nom) {
		compagnieAerienneRepository.findAllWithCompagnieAerienneVolByNom(nom);
	}

	public void creerCompagnieAerienne(String nom) {
		Optional<CompagnieAerienne> opt = compagnieAerienneRepository.findByNom(nom);
		if (opt.isPresent()) {
		} else {
			CompagnieAerienne compagnieAerienne = new CompagnieAerienne();
			compagnieAerienne.setNom(nom);
			compagnieAerienneRepository.save(compagnieAerienne);
		}
	}
	
	public void modifierNomCompagnieAerienne(Long id, String nom) {
		Optional<CompagnieAerienne> opt = compagnieAerienneRepository.findById(id);
		if(opt.isPresent()) {
			CompagnieAerienne compagnieAerienne = opt.get();
			compagnieAerienne.setNom(nom);
			compagnieAerienneRepository.save(compagnieAerienne);
		}
	}

	public void supprimerCompagnieAerienne(String nom) {
		Optional<CompagnieAerienne> opt = compagnieAerienneRepository.findByNom(nom);
		if (opt.isPresent()) {
			CompagnieAerienne compagnieAerienne = opt.get();
			compagnieAerienneRepository.delete(compagnieAerienne);
		}
	}
}
