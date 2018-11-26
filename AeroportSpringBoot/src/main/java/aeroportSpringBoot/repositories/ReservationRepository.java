package aeroportSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import aeroportSpringBoot.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
