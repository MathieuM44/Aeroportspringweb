package AeroportSpring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AeroportSpring.model.Adresse;
import AeroportSpring.model.Client;
import AeroportSpring.model.ClientEI;
import AeroportSpring.model.ClientPhysique;
import AeroportSpring.model.Login;
import AeroportSpring.model.Passager;
import AeroportSpring.model.Reservation;
import AeroportSpring.model.TitrePhysique;
import AeroportSpring.repositories.ClientRepository;
import AeroportSpring.repositories.LoginRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	LoginRepository loginRepository;

	public ClientService() {
	}

	// --------------Sous Méthodes (servant aux méthodes principales) --------------
	public Boolean clientExist(Long id) {
		Optional<Client> opt = clientRepository.findById(id);
		if (opt.isPresent()) {
			return true;
		} else {
			return false;
		}
	}

	public Client clientGet(Long id) {
		Client client = null;
		if (this.clientExist(id)) {
			Optional<Client> opt = clientRepository.findById(id);
			client = opt.get();
		}
		return client;
	}

	public List<Reservation> reservationGet(Long id) {
	
		Client client = clientRepository.clientGetReservation(id);
		return client.getReservations();
	}

	// ------------------- Methodes principales -----------------------------

	public String numVolPrint(Long id) {
		String s = "";
		Client client = null;

		if (this.clientExist(id)) {
			List<Reservation> reservations = this.reservationGet(id);
			for (Reservation reservation : reservations) {
				s += "Vous avez une reservation pour le vol numéro " + reservation.getNumero() + "\n";
			}
		} else {
			s = "L'id du client est inexistant dans la base de données ";
		}
		return s;
	}

	public List<Passager> findAllPassager(Long id) {

		List<Passager> passagers = new ArrayList<>();

		if (this.clientExist(id)) {
			List<Reservation> reservations = this.reservationGet(id);
			for (Reservation reservation : reservations) {
				passagers.add(reservation.getPassager());
			}
		}

		return passagers;
	}

	public Client CreateClientPhysique(String nom, Login login, Adresse adresse) {

		Client clientPhy = new ClientPhysique();
	
		// Rendre persistent un login
		if (login.getId() != null) {
			Optional<Login> optLo = loginRepository.findById(login.getId());
			if (optLo.isPresent()) {
				if (login.equals(optLo)) {
					//ne rien faire si les deux mdp sont égaux sinon en créer un en base
				} else {
					login.setId(null);
					loginRepository.save(login);
				}
			} else {
				loginRepository.save(login);
			}
		}else {
			loginRepository.save(login);
		}
		
		//Manager le login
		login = loginRepository.save(login);

		clientPhy.setLogin(login);
		clientPhy.setNom(nom);
		clientPhy.setAdresse(adresse);
		
		clientPhy = clientRepository.save(clientPhy);
		
		return clientPhy;
	}
	
	public Client createClientPhysique() {
		
		ClientPhysique clientPhy = new ClientPhysique();
		
		Adresse adresse = new Adresse();
		adresse.setAdresse("non renseigné");
		adresse.setVille("non renseigné");
		
		Login login = new Login("LoginParDefaut");
		login.setMotDePasse("MdpParDefaut");
		
		login = loginRepository.save(login);
		
		clientPhy.setAdresse(adresse);
		clientPhy.setLogin(login);
		clientPhy.setNom("NomParDefaut");
		
		clientPhy = clientRepository.save(clientPhy);
		
		return clientPhy;

		
	}

}
