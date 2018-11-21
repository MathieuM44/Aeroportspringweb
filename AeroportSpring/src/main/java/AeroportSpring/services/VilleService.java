package AeroportSpring.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AeroportSpring.model.Ville;
import AeroportSpring.repositories.VilleRepository;

@Service
public class VilleService {

	@Autowired
	private VilleRepository villeRepository;
	
	public void trouverAeroport(String nom) {
		villeRepository.findAllAeroportByNom(nom);
	}
	
	public void modifierNomVille(Long id, String nom) {
		Optional<Ville> opt = villeRepository.findById(id);
		if(opt.isPresent()) {
			Ville ville = opt.get();
			ville.setNom(nom);
			villeRepository.save(ville);
		}
	}
	
	public void creerVille(String nom) {
		Optional<Ville> opt = villeRepository.findByNom(nom);
		if(opt.isPresent()) {
		} else {
			Ville ville = new Ville();
			ville.setNom(nom);
			villeRepository.save(ville);
		}
	}
	
	public void supprimerVille(String nom) {
		Optional<Ville> opt = villeRepository.findByNom(nom);
		if(opt.isPresent()) {
			Ville ville = opt.get();
			villeRepository.delete(ville);
		} 
	}
}
