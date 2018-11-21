package AeroportSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import AeroportSpring.model.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {

	Login findByLogin(String login);
}
