package it.epicode.beservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.beservice.model.Provincia;
import it.epicode.beservice.repository.ProvinciaRepository;

@Service
public class ProvinciaService {
	@Autowired
	ProvinciaRepository provinciaRepo;

	public void saveProvincia(Provincia provincia) {
		this.provinciaRepo.save(provincia);
	}

	public void deleteProvincia(Long id) {
		this.provinciaRepo.deleteById(id);
	}

	public void updateProvincia(Provincia provincia) {
		Provincia p = this.provinciaRepo.findByIdProvincia(provincia.getId());
		p.setId(provincia.getId());
		p.setNome(provincia.getNome());
		p.setSigla(provincia.getSigla());
		this.provinciaRepo.flush();
	}

	public Provincia findByNome(String nome) {
		return provinciaRepo.findByNome(nome);
	}

}
