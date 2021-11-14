package it.epicode.beservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import it.epicode.beservice.model.Cliente;
import it.epicode.beservice.model.Indirizzo;
import it.epicode.beservice.service.ClienteService;
import it.epicode.beservice.service.IndirizzoService;

@Controller
@RequestMapping("/clientecontrollerhtml")
public class ClienteControllerhtml {
	@Autowired
	ClienteService clienteService;
	@Autowired
	IndirizzoService indirizzoService;

	@PostMapping("/savecliente")
	public String saveCliente(Cliente cliente) {
		this.clienteService.saveCliente(cliente);
		return "cliente salvato";
	}

	@PostMapping("/updatecliente")
	public String updateCliente(Cliente cliente) {
		this.clienteService.updateCliente(cliente);
		return "cliente aggiornato";
	}

	@GetMapping("/deletecliente/{id}")
	public ModelAndView deleteCliente(@PathVariable long id) {
		this.clienteService.deleteCliente(id);
		return findAll();
	}

	@GetMapping("/findall")
	public ModelAndView findAll() {
		List<Cliente> find = this.clienteService.findAll();
		if (!(find.isEmpty())) {
			ModelAndView view = new ModelAndView("lista.html");
			view.addObject("find", find);
			return view;
		} else {
			ModelAndView badrequest = new ModelAndView("badrequest.html");
			return badrequest;
		}
	}
	@GetMapping("showindirizzo/{indirizzo}")
	public ModelAndView showIndirizzo(@PathVariable Long indirizzo, ModelAndView model) {
		Indirizzo i=this.indirizzoService.findByid(indirizzo);
		model.setViewName("showindirizzo");
		model.addObject("indirizzo", i);
		return model;
	}
	
	@GetMapping("/updateindirizzo/{indirizzoId}")
	public ModelAndView updateindirizzo(@PathVariable Long indirizzoId) {
		Indirizzo i=this.indirizzoService.findByid(indirizzoId);
		this.indirizzoService.updateIndirizzo(i);
		return findAll();
	}
	
	@GetMapping("/ragionesocialeordinato/{pageNo}")
	public ModelAndView findByOrderByRagioneSociale(Pageable page,
			@RequestParam(required = false, defaultValue = "0") int pageNo) {
		Page<Optional<Cliente>> find = this.clienteService.findByOrderByRagioneSociale(page);
		List<Optional<Cliente>> list = find.getContent();
		if (find.hasContent()) {
			ModelAndView view = new ModelAndView("listaordinata.html");
			view.addObject("list", list);
			view.addObject("currentPage", pageNo);
			view.addObject("totalPages", find.getTotalPages());
			view.addObject("totalItems", find.getTotalElements());
			return view;
		} else {
			ModelAndView badrequest = new ModelAndView("badrequest.html");
			return badrequest;
		}
	}
		
	
	
	

//	@GetMapping("/findnome")
//	public ResponseEntity<?> findByOrderByRagioneSociale(Pageable page) {
//		Page<Optional<Cliente>> find = this.clienteService.findByOrderByRagioneSociale(page);
//		if (find.hasContent()) {
//			return new ResponseEntity<>(find, HttpStatus.OK);
//		} else
//			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
//	}
//
//	@GetMapping("/datainserimento")
//	public ResponseEntity<?> findByOrderByDataInserimento(Pageable page,
//			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data) {
//		Page<Optional<Cliente>> find = this.clienteService.findBydataInserimento(page, data);
//		if (find.hasContent()) {
//			return new ResponseEntity<>(find, HttpStatus.OK);
//		} else
//			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
//	}
//
//	@GetMapping("/ordinefatturatoannuale")
//	public ResponseEntity<?> findByOrderByFatturatoAnnuale(Pageable page) {
//		Page<Optional<Cliente>> find = this.clienteService.findByOrderByFatturatoAnnuale(page);
//		if (find.hasContent()) {
//			return new ResponseEntity<>(find, HttpStatus.OK);
//		} else
//			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
//	}
//
//	@GetMapping("/dataultimocontatto")
//	public ResponseEntity<?> findByOrderByDataUltimoContatto(Pageable page) {
//		Page<Optional<Cliente>> find = this.clienteService.findByOrderByDataUltimoContatto(page);
//		if (find.hasContent()) {
//			return new ResponseEntity<>(find, HttpStatus.OK);
//		} else
//			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
//	}
//
//	@GetMapping("/ordineprovincia")
//	public ResponseEntity<?> findByOrderByIndirizzoSedeLegale(Pageable page) {
//		Page<Optional<Cliente>> find = this.clienteService.findByOrderByIndirizzoSedeLegale(page);
//		if (find.hasContent()) {
//			return new ResponseEntity<>(find, HttpStatus.OK);
//		} else
//			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
//	}
//
//	@GetMapping("/fatturatoannuale")
//	public ResponseEntity<?> findByfatturatoAnnuale(Pageable page, @RequestParam String fatturato) {
//		Double fatt = Double.parseDouble(fatturato);
//		Page<Optional<Cliente>> find = this.clienteService.findByfatturatoAnnuale(page, fatt);
//		if (find.hasContent()) {
//			return new ResponseEntity<>(find, HttpStatus.OK);
//		} else
//			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
//	}
//
//	@GetMapping("/finddatainserimento")
//	public ResponseEntity<?> findBydataInserimento(Pageable page,
//			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data) {
//		Page<Optional<Cliente>> find = this.clienteService.findBydataInserimento(page, data);
//		if (find.hasContent()) {
//			return new ResponseEntity<>(find, HttpStatus.OK);
//		} else
//			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
//	}
//
//	@GetMapping("/ragionesociale")
//	public ResponseEntity<?> findByRagioneSociale(Pageable page, @RequestParam String nome) {
//		Page<Optional<Cliente>> find = this.clienteService.findByRagioneSociale(page, nome);
//		if (find.hasContent()) {
//			return new ResponseEntity<>(find, HttpStatus.OK);
//		} else
//			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
//	}

}
