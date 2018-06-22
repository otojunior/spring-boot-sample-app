/**
 * 
 */
package org.otojunior.sample.app.backend.rest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.otojunior.sample.app.backend.entity.Endereco;
import org.otojunior.sample.app.backend.entity.Uf;
import org.otojunior.sample.app.backend.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers=EnderecoRest.class, secure=false)
public class EnderecoRestTest {
	@MockBean
	private EnderecoService enderecoService;

	@Autowired
	private MockMvc mvc;
	
	/**
	 * Test method for {@link org.otojunior.sample.app.backend.rest.EnderecoRest#findById(java.lang.Long)}.
	 * @throws Exception 
	 */
	@Test
	public void testFindAllComRegistros() throws Exception {
		given(enderecoService.findAll()).
		willReturn(enderecos());
		
		mvc.perform(get("/api/endereco").accept(MediaType.APPLICATION_JSON_UTF8)).
			andExpect(status().isOk()).
			andExpect(jsonPath("$[0].logradouro", equalTo("Rua Teste de Unidade 1"))).
			andExpect(jsonPath("$[0].numero", equalTo("1201"))).
			andExpect(jsonPath("$[0].bairro", equalTo("Bairro Teste 1"))).
			andExpect(jsonPath("$[0].cidade", equalTo("Belo Horizonte"))).
			andExpect(jsonPath("$[0].uf", equalTo("MG"))).
			andExpect(jsonPath("$[0].cep", equalTo("12345678"))).
			andExpect(jsonPath("$[1].logradouro", equalTo("Rua Teste de Unidade 2"))).
			andExpect(jsonPath("$[1].numero", equalTo("1202"))).
			andExpect(jsonPath("$[1].bairro", equalTo("Bairro Teste 2"))).
			andExpect(jsonPath("$[1].cidade", equalTo("Belo Horizonte"))).
			andExpect(jsonPath("$[1].uf", equalTo("MG"))).
			andExpect(jsonPath("$[1].cep", equalTo("22345678")));
	}

	/**
	 * Test method for {@link org.otojunior.sample.app.backend.rest.EnderecoRest#findByCep(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testFindByCepEncontrado() throws Exception {
		Optional<Endereco> opt = Optional.of(enderecos().get(0));
		
		given(enderecoService.findByCep("12345678")).
		willReturn(opt);
		
		mvc.perform(get("/api/endereco?cep=12345678").accept(MediaType.APPLICATION_JSON_UTF8)).
			andExpect(status().isOk()).
			andExpect(jsonPath("$.logradouro", equalTo("Rua Teste de Unidade 1"))).
			andExpect(jsonPath("$.numero", equalTo("1201"))).
			andExpect(jsonPath("$.bairro", equalTo("Bairro Teste 1"))).
			andExpect(jsonPath("$.cidade", equalTo("Belo Horizonte"))).
			andExpect(jsonPath("$.uf", equalTo("MG"))).
			andExpect(jsonPath("$.cep", equalTo("12345678")));
	}

	/**
	 * Test method for {@link org.otojunior.sample.app.backend.rest.EnderecoRest#findAll()}.
	 * @throws Exception 
	 */
	@Test
	public void testFindById() throws Exception {
		Optional<Endereco> opt = Optional.of(enderecos().get(1));
		
		given(enderecoService.findById(2L)).
		willReturn(opt);
		
		mvc.perform(get("/api/endereco/2").accept(MediaType.APPLICATION_JSON_UTF8)).
			andExpect(status().isOk()).
			andExpect(jsonPath("$.logradouro", equalTo("Rua Teste de Unidade 2"))).
			andExpect(jsonPath("$.numero", equalTo("1202"))).
			andExpect(jsonPath("$.bairro", equalTo("Bairro Teste 2"))).
			andExpect(jsonPath("$.cidade", equalTo("Belo Horizonte"))).
			andExpect(jsonPath("$.uf", equalTo("MG"))).
			andExpect(jsonPath("$.cep", equalTo("22345678")));
	}
	
	/**
	 * 
	 * @return
	 */
	private List<Endereco> enderecos() {
		final int N = 3; 
		List<Endereco> enderecos = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			Endereco endereco = new Endereco();
			endereco.setAtivo(i == N ? true : false);
			endereco.setLogradouro("Rua Teste de Unidade " + i);
			endereco.setNumero("120" + i);
			endereco.setBairro("Bairro Teste " + i);
			endereco.setCidade("Belo Horizonte");
			endereco.setUf(Uf.MG);
			endereco.setCep(i + "2345678");
			enderecos.add(endereco);
		}
		return enderecos;
	}
}
