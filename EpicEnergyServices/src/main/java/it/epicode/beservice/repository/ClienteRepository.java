package it.epicode.beservice.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.epicode.beservice.model.Cliente;
import it.epicode.beservice.model.Provincia;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	Page<Optional<Cliente>> findByOrderByRagioneSocialeAsc(Pageable pageable);

	Page<Optional<Cliente>> findByOrderByFatturatoAnnualeAsc(Pageable pageable);

	Page<Optional<Cliente>> findByOrderByDataInserimentoAsc(Pageable pageable);

	Page<Optional<Cliente>> findByOrderByDataUltimoContattoAsc(Pageable pageable);

	Page<Optional<Cliente>> findByIndirizzosedelegaleComuneProvinciaOrderByIndirizzosedelegaleComuneProvinciaAsc(
			Pageable pageable, Provincia provincia);

	@Query("SELECT c FROM Cliente c WHERE fatturatoAnnuale >=:fatturato")
	Page<Optional<Cliente>> findByFatturatoAnnuale(Pageable pageable, Double fatturato);

	Page<Optional<Cliente>> findByDataInserimento(Pageable pageable, LocalDate data);

	Page<Optional<Cliente>> findByDataUltimoContatto(Pageable pageable, LocalDate data);

	@Query("SELECT c FROM Cliente c  WHERE c.ragioneSociale LIKE %:nome%")
	Page<Optional<Cliente>> findByRagioneSociale(Pageable pageable, String nome);

	@Query("Select c from Cliente c where c.id=:id")
	Cliente findByIdCliente(Long id);

}
