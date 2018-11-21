package AeroportSpring.services;

import org.springframework.beans.factory.annotation.Autowired;

import AeroportSpring.repositories.ReservationRepository;

public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;
	
}
