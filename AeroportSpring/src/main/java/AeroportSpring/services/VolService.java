package AeroportSpring.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AeroportSpring.model.Aeroport;
import AeroportSpring.model.Vol;
import AeroportSpring.repositories.VolRepository;

@Service
public class VolService {

	@Autowired
	private VolRepository volRepository;
	
	public void trouverAeroports() {
		volRepository.findAllAeroportDepartAndAeroportArrivee();
	}
	
	public void trouverEscales() {
		volRepository.findAllEscale();
	}
	
	public void trouverReservations() {
		volRepository.findAllReservation();
	}
	
	public void trouverCompagniesAeriennes() {
		volRepository.findAllCompagnieAerienne();
	}
	
	public void trouverCompagniesAeriennesVol() {
		volRepository.findAllCompagnieAerienneVol();
	}
	
	public void trouverAeroports(Long id) {
		volRepository.findAllAeroportDepartAndAeroportArriveeById(id);
	}
	
	public void trouverEscales(Long id) {
		volRepository.findAllEscaleById(id);
	}
	
	public void trouverReservations(Long id) {
		volRepository.findAllReservationById(id);
	}
	
	public void trouverCompagniesAeriennes(Long id) {
		volRepository.findAllCompagnieAerienneById(id);
	}
	
	public void trouverCompagniesAeriennesVol(Long id) {
		volRepository.findAllCompagnieAerienneVolById(id);
	}
	
	public void creerVol(Vol vol) {
		if(vol.getId() != null) {
			if(volRepository.findById(vol.getId()) != null) {
			}
		} else {
			volRepository.save(vol);
		}
	}
	
	public void supprimerVol(Vol vol) {
		if(volRepository.findById(vol.getId()) != null) {
			volRepository.delete(vol);
		}
	}
	
	public void modifierDateDepart(Long id, Date date) {
		Optional<Vol> opt = volRepository.findById(id);
		if(opt.isPresent()) {
			Vol vol = opt.get();
			vol.setDateDepart(date);
			volRepository.save(vol);
		}
	}
	
	public void modifierDateArrivee(Long id, Date date) {
		Optional<Vol> opt = volRepository.findById(id);
		if(opt.isPresent()) {
			Vol vol = opt.get();
			vol.setDateArrivee(date);
			volRepository.save(vol);
		}
	}
	
	public void modifierHeureDepart(Long id, Date date) {
		Optional<Vol> opt = volRepository.findById(id);
		if(opt.isPresent()) {
			Vol vol = opt.get();
			vol.setHeureDepart(date);
			volRepository.save(vol);
		}
	}
	
	public void modifierHeureArrivee(Long id, Date date) {
		Optional<Vol> opt = volRepository.findById(id);
		if(opt.isPresent()) {
			Vol vol = opt.get();
			vol.setHeureArrivee(date);
			volRepository.save(vol);
		}
	}
	
	public void modifierAeroportDepart(Long id, Aeroport aeroportDepart) {
		Optional<Vol> opt = volRepository.findById(id);
		if(opt.isPresent()) {
			Vol vol = opt.get();
			vol.setAeroportDepart(aeroportDepart);
			volRepository.save(vol);
		}
	}
	
	public void modifierAeroportArrivee(Long id, Aeroport aeroportArrivee) {
		Optional<Vol> opt = volRepository.findById(id);
		if(opt.isPresent()) {
			Vol vol = opt.get();
			vol.setAeroportArrivee(aeroportArrivee);
			volRepository.save(vol);
		}
	}
	
	public void modifierDateDepart(Vol vol, Date date) {
		if(vol.getId() != null) {
			if(volRepository.findById(vol.getId()) != null) {
				vol.setDateDepart(date);
				volRepository.save(vol);
			}
		} 
	}
	
	public void modifierDateArrivee(Vol vol, Date date) {
		if(vol.getId() != null) {
			if(volRepository.findById(vol.getId()) != null) {
				vol.setDateArrivee(date);
				volRepository.save(vol);
			}
		} 
	}
	
	public void modifierHeureDepart(Vol vol, Date date) {
		if(vol.getId() != null) {
			if(volRepository.findById(vol.getId()) != null) {
				vol.setHeureDepart(date);
				volRepository.save(vol);
			}
		} 
	}
	
	public void modifierHeureArrivee(Vol vol, Date date) {
		if(vol.getId() != null) {
			if(volRepository.findById(vol.getId()) != null) {
				vol.setHeureArrivee(date);
				volRepository.save(vol);
			}
		} 
	}
	
	public void modifierAeroportDepart(Vol vol, Aeroport aeroportDepart) {
		if(vol.getId() != null) {
			if(volRepository.findById(vol.getId()) != null) {
				vol.setAeroportDepart(aeroportDepart);
				volRepository.save(vol);
			}
		}
	}
	
	public void modifierAeroportArrivee(Vol vol, Aeroport aeroportArrivee) {
		if(vol.getId() != null) {
			if(volRepository.findById(vol.getId()) != null) {
				vol.setAeroportArrivee(aeroportArrivee);
				volRepository.save(vol);
			}
		}
	}
	
}
