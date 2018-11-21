package AeroportSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import AeroportSpring.model.Passager;

public interface PassagerRepository extends JpaRepository<Passager, Long> {

}
