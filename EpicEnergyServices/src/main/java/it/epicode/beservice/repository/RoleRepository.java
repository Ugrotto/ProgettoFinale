package it.epicode.beservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.beservice.model.Erole;
import it.epicode.beservice.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	public Page<Role> findAll(Pageable pageable);

	public List<Role> findByOrderByIdAsc();

//	Optional<Role> findByERole(ERole eRole);

	Optional<Role> findByErole(Erole erole);

}
