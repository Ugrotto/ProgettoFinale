package it.epicode.beservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.beservice.model.StatoFattura;
import it.epicode.beservice.repository.StatoFatturaRepository;

@Service
public class StatoFatturaService {
	@Autowired
	StatoFatturaRepository statoFatturaRepo;

	public void saveStatoFattura(StatoFattura statoFattura) {
		this.statoFatturaRepo.save(statoFattura);
	}

	public void deleteStatoFattura(Long id) {
		this.statoFatturaRepo.deleteById(id);
	}

	public void updateStatoFattura(StatoFattura statoFattura) {
		StatoFattura f = this.statoFatturaRepo.findByIdStato(statoFattura.getId());
		f.setId(statoFattura.getId());
		f.setNome(statoFattura.getNome());
		this.statoFatturaRepo.flush();
	}

}
