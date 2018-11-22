package AeroportSpring.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import AeroportSpring.model.Client;
public interface ClientRepository extends JpaRepository<Client, Long> {

	Optional<Client> clientGetReservation(@Param("idC")Long id);
	Client clientGetPassager(@Param("idC")Long id);
	List<Client> clientWithReservation();



}
