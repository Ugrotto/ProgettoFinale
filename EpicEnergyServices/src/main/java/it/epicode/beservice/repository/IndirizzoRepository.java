package it.epicode.beservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.epicode.beservice.model.Indirizzo;

public interface IndirizzoRepository extends JpaRepository<Indirizzo, Long>{

	@Query("Select i from Indirizzo i where i.id=:id")
	Indirizzo findByIdIndirizzo(Long id);

}
