package AeroportSpring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import AeroportSpring.model.Aeroport;
import AeroportSpring.model.Passager;
import AeroportSpring.model.Reservation;
import AeroportSpring.model.Ville;
import AeroportSpring.model.Vol;
import AeroportSpring.repositories.PassagerRepository;


@Service
public class PassagerService {


	@Autowired
	private PassagerRepository passagerRepository;
	

	public void NumeroReservationPassager(Passager passager) {
		List<Reservation> reservations = passager.getReservations();
		for (int i = 0; i < reservations.size(); i++) {
			Reservation obj = reservations.get(i);
			System.out.println("voici le numero de passager" + obj.getNumero());
		}
	}

	public void AeroportDepartdupassager(Passager passager) {
		List<Reservation> reservation = passager.getReservations();
		Vol vol;
		for (int i = 0; i < reservation.size(); i++) {
			Reservation obj = reservation.get(i);
			vol = obj.getVol();
			System.out.println("voici l'aeroport de depart du passager" + vol.getAeroportDepart());
		}

	}

	public void AeroportArriveedupassager(Passager passager) {
		List<Reservation> reservation = passager.getReservations();
		Vol vol;
		for (int i = 0; i < reservation.size(); i++) {
			Reservation obj = reservation.get(i);
			vol = obj.getVol();
			System.out.println("voici l'aeroport d'arrivee du passager" + vol.getAeroportArrivee());
		}

	}

	public void EscaleDuPassager(Passager passager) {
		List<Reservation> reservation = passager.getReservations();
		Vol vol;
		for (int i = 0; i < reservation.size(); i++) {
			Reservation obj = reservation.get(i);
			vol = obj.getVol();
			System.out.println("voici l'escale du passager" + vol.getEscale());
		}

	}

	public void VilleArriveePassager(Passager passager) {
		List<Reservation> reservation = passager.getReservations();
		Vol vol;
		Aeroport aeroport;
		for (int i = 0; i < reservation.size(); i++) {
			Reservation obj = reservation.get(i);
			vol = obj.getVol();
			aeroport = vol.getAeroportArrivee();
			System.out.println("la ville d'arrivee est:" +aeroport.getVilleAeroports());

		}

	}

}