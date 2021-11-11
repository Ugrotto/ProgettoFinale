package it.epicode.beservice.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.epicode.beservice.model.StatoFattura;

public interface StatoFatturaRepository extends JpaRepository<StatoFattura, Long> {

	public Page<StatoFattura> findAll(Pageable pageable);

	public List<StatoFattura> findByOrderByIdAsc();

	@Query("Select s from StatoFattura s where s.id=:id")
	public StatoFattura findByIdStato(Long id);

}
