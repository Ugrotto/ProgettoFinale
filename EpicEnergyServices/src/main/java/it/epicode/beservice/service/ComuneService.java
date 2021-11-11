package it.epicode.beservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.beservice.model.Comune;
import it.epicode.beservice.repository.ComuneRepository;

@Service
public class ComuneService {
	@Autowired
	ComuneRepository comuneRepo;

	public void saveComune(Comune comune) {
		this.comuneRepo.save(comune);
	}

	public void deleteComune(Long id) {
		this.comuneRepo.deleteById(id);
	}

	public void updateComune(Comune comune) {
		Comune c = this.comuneRepo.findByIdComune(comune.getId());
		c.setId(comune.getId());
		c.setNome(comune.getNome());
		c.setProvincia(comune.getProvincia());
		this.comuneRepo.flush();
	}

}
