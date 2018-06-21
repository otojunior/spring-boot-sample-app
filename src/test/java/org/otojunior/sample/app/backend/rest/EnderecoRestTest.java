/**
 * 
 */
package org.otojunior.sample.app.backend.rest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.otojunior.sample.app.backend.entity.Endereco;
import org.otojunior.sample.app.backend.entity.Uf;
import org.otojunior.sample.app.backend.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(EnderecoRest.class)
public class EnderecoRestTest {
	@MockBean
	private EnderecoService enderecoService;

	@Autowired
	private MockMvc mvc;
	
	

	
	/**
	 * Test method for {@link org.otojunior.sample.app.backend.rest.EnderecoRest#findAll()}.
	 * @throws Exception 
	 */
	@Test
	@WithMockUser(username="user", password="passwd")
	public void testFindById() throws Exception {
		Endereco endereco = new Endereco();
		endereco.setAtivo(true);
		endereco.setLogradouro("Rua Teste de Unidade");
		endereco.setNumero("123A");
		endereco.setBairro("Bairro Teste");
		endereco.setCidade("Belo Horizonte");
		endereco.setUf(Uf.MG);
		endereco.setCep("31234567");
		Optional<Endereco> opt = Optional.of(endereco);
		
		BDDMockito.
			given(enderecoService.findById(1L)).
			willReturn(opt);
		
		mvc.perform(get("/api/endereco/1").accept(MediaType.APPLICATION_JSON_UTF8)).
			andExpect(status().isOk()).
			andExpect(jsonPath("$.logradouro", equalTo("Rua Teste de Unidade"))).
			andExpect(jsonPath("$.numero", equalTo("123A"))).
			andExpect(jsonPath("$.bairro", equalTo("Bairro Teste"))).
			andExpect(jsonPath("$.cidade", equalTo("Belo Horizonte"))).
			andExpect(jsonPath("$.uf", equalTo("MG"))).
			andExpect(jsonPath("$.cep", equalTo("31234567")));
	}

	/**
	 * Test method for {@link org.otojunior.sample.app.backend.rest.EnderecoRest#findByCep(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	@WithMockUser(username="user", password="passwd")
	public void testFindByCep() throws Exception {
		Endereco endereco = new Endereco();
		endereco.setAtivo(true);
		endereco.setLogradouro("Rua Teste de Unidade");
		endereco.setNumero("123A");
		endereco.setBairro("Bairro Teste");
		endereco.setCidade("Belo Horizonte");
		endereco.setUf(Uf.MG);
		endereco.setCep("31234567");
		Optional<Endereco> opt = Optional.of(endereco);
		
		BDDMockito.
			given(enderecoService.findByCep("31234567")).
			willReturn(opt);
		
		mvc.perform(get("/api/endereco?cep=31234567").accept(MediaType.APPLICATION_JSON_UTF8)).
			andExpect(status().isOk()).
			andExpect(jsonPath("$.logradouro", equalTo("Rua Teste de Unidade"))).
			andExpect(jsonPath("$.numero", equalTo("123A"))).
			andExpect(jsonPath("$.bairro", equalTo("Bairro Teste"))).
			andExpect(jsonPath("$.cidade", equalTo("Belo Horizonte"))).
			andExpect(jsonPath("$.uf", equalTo("MG"))).
			andExpect(jsonPath("$.cep", equalTo("31234567")));
	}

	/**
	 * Test method for {@link org.otojunior.sample.app.backend.rest.EnderecoRest#findById(java.lang.Long)}.
	 * @throws Exception 
	 */
	@Test
	@WithMockUser(username="user", password="passwd")
	public void testFindAll() throws Exception {
		Endereco endereco = new Endereco();
		endereco.setAtivo(true);
		endereco.setLogradouro("Rua Teste de Unidade");
		endereco.setNumero("123A");
		endereco.setBairro("Bairro Teste");
		endereco.setCidade("Belo Horizonte");
		endereco.setUf(Uf.MG);
		endereco.setCep("31234567");
		List<Endereco> lst = Collections.singletonList(endereco);
		
		BDDMockito.
			given(enderecoService.findAll()).
			willReturn(lst);
		
		mvc.perform(get("/api/endereco").accept(MediaType.APPLICATION_JSON_UTF8)).
			andExpect(status().isOk()).
			andExpect(jsonPath("$[0].logradouro", equalTo("Rua Teste de Unidade"))).
			andExpect(jsonPath("$[0].numero", equalTo("123A"))).
			andExpect(jsonPath("$[0].bairro", equalTo("Bairro Teste"))).
			andExpect(jsonPath("$[0].cidade", equalTo("Belo Horizonte"))).
			andExpect(jsonPath("$[0].uf", equalTo("MG"))).
			andExpect(jsonPath("$[0].cep", equalTo("31234567")));
	}
}
