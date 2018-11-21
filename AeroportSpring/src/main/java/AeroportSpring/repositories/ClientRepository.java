package AeroportSpring.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import AeroportSpring.model.Client;
import AeroportSpring.model.Reservation;


public interface ClientRepository extends JpaRepository<Client, Long>{

	Client clientGetReservation(@Param("idC")Long id);
	


}
