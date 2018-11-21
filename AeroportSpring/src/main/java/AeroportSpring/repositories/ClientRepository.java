package AeroportSpring.repositories;

<<<<<<< HEAD
import java.util.List;
import java.util.Optional;

import javax.persistence.NamedQuery;

=======
>>>>>>> master
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import AeroportSpring.model.Client;

<<<<<<< HEAD
	Optional<Client> clientGetReservation(@Param("idC")Long id);
	Client clientGetPassager(@Param("idC")Long id);
	List<Client> clientWithReservation();

=======
public interface ClientRepository extends JpaRepository<Client, Long> {
>>>>>>> master

	Client clientGetReservation(@Param("idC") Long id);

}
