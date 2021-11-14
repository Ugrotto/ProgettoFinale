package it.epicode.beservice.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.beservice.model.Cliente;
import it.epicode.beservice.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepo;

	public void saveCliente(Cliente cliente) {
		this.clienteRepo.save(cliente);
	}

	public void deleteCliente(Long id) {
		this.clienteRepo.deleteById(id);
	}

	public void updateCliente(Cliente cliente) {
		Cliente c = this.clienteRepo.findByIdCliente(cliente.getId());
		c.setId(cliente.getId());
		c.setCognomeContatto(cliente.getCognomeContatto());
		c.setDataInserimento(cliente.getDataInserimento());
		c.setDataUltimoContatto(cliente.getDataUltimoContatto());
		c.setEmail(cliente.getEmail());
		c.setEmailContatto(cliente.getEmailContatto());
		c.setNomeContatto(cliente.getNomeContatto());
		c.setFatturatoAnnuale(cliente.getFatturatoAnnuale());
		c.setIndirizzosedelegale(cliente.getIndirizzosedelegale());
		c.setIndirizzosedeoperativa(cliente.getIndirizzosedeoperativa());
		c.setPartitaIva(cliente.getPartitaIva());
		c.setPec(cliente.getPec());
		c.setRagioneSociale(cliente.getRagioneSociale());
		c.setTelefono(cliente.getTelefono());
		c.setTelefonoContatto(cliente.getTelefonoContatto());
		c.setTipoCliente(cliente.getTipoCliente());
		this.clienteRepo.flush();
	}

	public Page<Optional<Cliente>> findByOrderByRagioneSociale(Pageable page) {
		return this.clienteRepo.findByOrderByRagioneSocialeAsc(page);
	}

	public Page<Optional<Cliente>> findByOrderByDataInserimento(Pageable page) {
		return this.clienteRepo.findByOrderByDataInserimentoAsc(page);
	}

	public Page<Optional<Cliente>> findByOrderByFatturatoAnnuale(Pageable page) {
		return this.clienteRepo.findByOrderByFatturatoAnnualeAsc(page);
	}

	public Page<Optional<Cliente>> findByOrderByDataUltimoContatto(Pageable page) {
		return this.clienteRepo.findByOrderByDataUltimoContattoAsc(page);
	}

	public Page<Optional<Cliente>> findByOrderByIndirizzoSedeLegale(Pageable page) {
		return this.clienteRepo.findByOrderByIndirizzosedelegaleComuneProvinciaAsc(page);
	}

	public Page<Optional<Cliente>> findByfatturatoAnnuale(Pageable page, Double fatturato) {
		return this.clienteRepo.findByFatturatoAnnuale(page, fatturato);
	}

	public Page<Optional<Cliente>> findBydataInserimento(Pageable page, LocalDate data) {
		return this.clienteRepo.findByDataInserimento(page, data);
	}

	public Page<Optional<Cliente>> findByRagioneSociale(Pageable page, String nome) {
		return this.clienteRepo.findByRagioneSociale(page, nome);
	}
	public Cliente findByIdCliente(Long id) {
		return this.clienteRepo.findByIdCliente(id);
	}
	public Optional<Cliente> findId(Long id){
		return this.clienteRepo.findById(id);
	}

	public List<Cliente> findAll() {
		return this.clienteRepo.findAll();
	}
	
}
