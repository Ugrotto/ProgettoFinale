package it.epicode.beservice.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.beservice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Page<User> findByNome(String nome, Pageable pageable);

	Optional<User> findByUsername(String nome);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

}
