package AeroportSpring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AeroportSpring.model.Aeroport;
import AeroportSpring.repositories.AeroportRepository;

@Service
public class AeroportService {

	@Autowired
	private AeroportRepository aeroportRepository;

	public void trouverVille() {
		aeroportRepository.findAllVille();
	}

	public void trouverVille(String nom) {
		aeroportRepository.findAllVilleByNom(nom);
	}

	public void trouverVol() {
		aeroportRepository.findAllWithVolsDepartAndVolsArrivee();
	}

	public void trouverVol(String nom) {
		aeroportRepository.findVolsDepartAndVolsArriveeByNom(nom);
	}

	public void trouverEscale() {
		aeroportRepository.findAllEscale();
	}

	public void trouverEscale(String nom) {
		aeroportRepository.findAllEscaleByNom(nom);
	}

	public void creerAeroport(String nom) {
		Optional<Aeroport> opt = aeroportRepository.findByNom(nom);
		if (opt.isPresent()) {
		} else {
			Aeroport aeroport = new Aeroport();
			aeroport.setNom(nom);
			aeroportRepository.save(aeroport);
		}
	}

	public void creerAeroport(Aeroport aeroport) {
		Optional<Aeroport> opt = aeroportRepository.findByNom(aeroport.getNom());
		if (opt.isPresent()) {
		} else {
			aeroportRepository.save(aeroport);
		}
	}

	public void supprimerAeroport(String nom) {
		Optional<Aeroport> opt = aeroportRepository.findByNom(nom);
		if (opt.isPresent()) {
			Aeroport aeroport = opt.get();
			aeroportRepository.delete(aeroport);
		}
	}

	public void supprimerAeroport(Aeroport aeroport) {
		Optional<Aeroport> opt = aeroportRepository.findByNom(aeroport.getNom());
		if (opt.isPresent()) {
			aeroportRepository.delete(aeroport);
		}
	}

	public void modifierNomAeroport(Long id, String nom) {
		if (aeroportRepository.findById(id) != null) {
			Optional<Aeroport> opt = aeroportRepository.findById(id);
			Aeroport aeroport = opt.get();
			aeroport.setNom(nom);
			aeroportRepository.save(aeroport);
		}
	}

	public void modifierNomAeroport(Aeroport aeroport, String nom) {
		if (aeroportRepository.findById(aeroport.getId()) != null) {
			Optional<Aeroport> opt = aeroportRepository.findById(aeroport.getId());
			Aeroport a = opt.get();
			aeroport.setNom(nom);
			aeroportRepository.save(a);
		}
	}

}
