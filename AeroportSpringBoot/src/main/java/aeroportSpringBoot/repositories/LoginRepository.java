package aeroportSpringBoot.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import aeroportSpringBoot.model.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {

	Optional<Login> findByLogin(String login);
//	Login findByIdWithClient(Long id);
}
