package aeroportSpringBoot.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aeroportSpringBoot.model.Adresse;
import aeroportSpringBoot.model.Client;
import aeroportSpringBoot.model.ClientPhysique;
import aeroportSpringBoot.model.Login;
import aeroportSpringBoot.model.Passager;
import aeroportSpringBoot.model.Reservation;
import aeroportSpringBoot.repositories.ClientRepository;
import aeroportSpringBoot.repositories.LoginRepository;
import aeroportSpringBoot.repositories.ReservationRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	LoginRepository loginRepository;

	@Autowired
	ReservationRepository reservationRepos;

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

		Optional<Client> opt = clientRepository.clientGetReservation(id);
		if (opt.isPresent()) {
			Client client = opt.get();
			return client.getReservations();

		}
		return null;
	}

	// ------------------- Methodes principales -----------------------------

	public String numVolPrint(Long id) {
		String s = "";
//		Client client = null;

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

	public Client GetWithResa(Long id) {

		Optional<Client> opt = clientRepository.clientGetReservation(id);
		if (opt.isPresent()) {
			Client client = opt.get();
			return client;

		}
		Optional<Client> opt2 = clientRepository.findById(id);
		Client client = opt2.get();

		return client;

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

	public Client CreateClient(Client client, Login login, Adresse adresse) {

		// Rendre persistent un login
		if (login.getId() != null) {
			Optional<Login> optLo = loginRepository.findById(login.getId());
			if (optLo.isPresent()) {
				if (login.equals(optLo)) {
					// ne rien faire si les deux mdp sont égaux sinon en créer un en base
				} else {
					login.setId(null);
					loginRepository.save(login);
				}
			} else {
				loginRepository.save(login);
			}
		} else {
			loginRepository.save(login);
		}

		// Manager le login
		login = loginRepository.save(login);

		client.setLogin(login);
		client.setAdresse(adresse);

		client = clientRepository.save(client);

		return client;
	}

	public void delete(Long id) {
		Optional<Client> opt = clientRepository.clientGetReservation(id);
		if (opt.isPresent()) {
			Client client = opt.get();
			for (Reservation reservation : client.getReservations()) {
				reservation.setClient(null);
				reservationRepos.save(reservation);
			}
			clientRepository.delete(client);
		} else {

			Optional<Client> opt2 = clientRepository.findById(id);

			Client client = opt2.get();

			clientRepository.delete(client);
		}

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
