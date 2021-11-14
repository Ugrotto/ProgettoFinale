package it.epicode.beservice.service.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import it.epicode.beservice.model.Cliente;
import it.epicode.beservice.repository.ClienteRepository;
import it.epicode.beservice.service.ClienteService;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class ClienteServiceTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	ClienteRepository clienteRepo;

	@Mock
	ClienteService clienteService;
	

	@Test
	void testFindNome() throws Exception {
		this.mockMvc.perform(get("/clientecontroller/findnome")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("rag")));
	}
		

	@Test
	public void testSaveCliente() throws Exception {
		this.mockMvc.perform(post("/clientecontroller/savecliente").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content("{\r\n" + "    \"ragioneSociale\":\"gianvitononascoltalepersoneparte96\",\r\n"
						+ "    \"partitaIva\":\"9666521\",\r\n" 
						+ "    \"tipoCliente\":\"SRL\",\r\n"
						+ "    \"email\":\"gianvitononascoltalepersoneparte96@96.com.com\",\r\n"
						+ "    \"pec\":\"gianvitononascoltalepersoneparte96@96.com\",\r\n"
						+ "    \"telefono\":\"123456\",\r\n" 
						+ "    \"nomeContatto\":\"nomecontatto2\",\r\n"
						+ "    \"cognomeContatto\":\"cognomecontatto2\",\r\n"
						+ "    \"telefonoContatto\":\"1234567\",\r\n"
						+ "    \"emailContatto\":\"emailcontatto@email.com\",\r\n"
						+ "    \"indirizzosedeoperativa\":{\r\n" 
						+ "    \"id\":\"2\",    \r\n"
						+ "    \"via\":\"Via 3\",\r\n" 
						+ "    \"civico\":\"123\",\r\n" + "    \"cap\":\"00000\",\r\n"
						+ "    \"localita\":\"localita3\",\r\n" + "    \"comune\":{\r\n" + "        \"id\":\"545\",\r\n"
						+ "        \"nome\":\"Ceva\",\r\n" + "        \"provincia\":{\r\n"
						+ "            \"id\":\"32\",\r\n" + "            \"nome\":\"Ceva\",\r\n"
						+ "            \"sigla\":\"CN\"\r\n" + "\r\n" + "        }\r\n" + "    }\r\n" + "},\r\n"
						+ "\"indirizzosedelegale\":{\r\n" + "    \"id\":\"2\",    \r\n" + "    \"via\":\"Via 3\",\r\n"
						+ "    \"civico\":\"123\",\r\n" + "    \"cap\":\"00000\",\r\n"
						+ "    \"localita\":\"localita3\",\r\n" + "    \"comune\":{\r\n" + "        \"id\":\"545\",\r\n"
						+ "        \"nome\":\"Ceva\",\r\n" + "        \"provincia\":{\r\n"
						+ "            \"id\":\"32\",\r\n" + "            \"nome\":\"Ceva\",\r\n"
						+ "            \"sigla\":\"CN\"\r\n" + "\r\n" + "        }\r\n" + "    }\r\n" + "},\r\n"
						+ "\"dataInserimento\":\"2021-12-12\",\r\n" + "\"dataUltimoContatto\":\"2021-12-12\",\r\n"
						+ "\"fatturatoAnnuale\":\"10000\"\r\n" + "}")
				.with(csrf())).andExpect(content().string("cliente salvato"));
//		verify(clienteService).saveCliente(cliente);
	}
//@Test
//	public void testDeleteCliente() throws Exception {
//		this.mockMvc.perform(get("/clientecontroller/deletecliente?id=16")).andDo(print())
//				.andExpect(content().string(containsString("cliente cancellato")));
//	}

}
