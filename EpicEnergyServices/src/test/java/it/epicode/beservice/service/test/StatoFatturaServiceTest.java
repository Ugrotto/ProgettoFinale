package it.epicode.beservice.service.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import it.epicode.beservice.model.StatoFattura;
import it.epicode.beservice.service.StatoFatturaService;

import org.junit.jupiter.api.BeforeEach;

@ExtendWith(MockitoExtension.class)
class StatoFatturaServiceTest {

	@Mock
	StatoFatturaService sfService;

	StatoFattura sf;

	@BeforeEach
	void setUp() throws Exception {
		StatoFattura stat = new StatoFattura();
		stat.setNome("nome");
	}

	@Test
	@DisplayName("salva stato fattura")
	void testSaveStatoFattura() {
		sfService.saveStatoFattura(sf);
	}

}
