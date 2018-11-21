package AeroportSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import AeroportSpring.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

	Client clientGetReservation(@Param("idC") Long id);

}
