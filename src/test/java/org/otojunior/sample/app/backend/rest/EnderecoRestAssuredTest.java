/**
 * 
 */
package org.otojunior.sample.app.backend.rest;

import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.otojunior.sample.app.backend.entity.Endereco;
import org.otojunior.sample.app.backend.entity.Uf;
import org.otojunior.sample.app.backend.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers=EnderecoRest.class, secure=false)
public class EnderecoRestAssuredTest {
	private static List<Endereco> enderecos;
	
	/**
	 * 
	 */
	@BeforeClass
	public static void beforeClass() {
		final int N = 3; 
		enderecos = new ArrayList<>();
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
	}

	@MockBean
	private EnderecoService enderecoService;
	
	@Autowired
	private MockMvc mvc;
	
	/**
	 * Test method for {@link org.otojunior.sample.app.backend.rest.EnderecoRest#findAll()}.
	 * @throws Exception 
	 */
	@Test
	public void testFindAll() throws Exception {
		BDDMockito.
			given(enderecoService.findAll()).
			willReturn(enderecos);
		
		RestAssuredMockMvc.
			given().mockMvc(mvc).
			when().get("/api/endereco").
			then().
				statusCode(200).
				root("[1]").
				body("logradouro", equalTo("Rua Teste de Unidade 2")).
				body("numero", equalTo("1202")).
				body("bairro", equalTo("Bairro Teste 2")).
				body("cidade", equalTo("Belo Horizonte")).
				body("uf", equalTo(Uf.MG.getSigla())).
				body("cep", equalTo("22345678"));
	}
	
	/**
	 * Test method for {@link org.otojunior.sample.app.backend.rest.EnderecoRest#findAll()}.
	 * @throws Exception 
	 */
	@Test
	public void testFindByCep() throws Exception {
		Optional<Endereco> opt = Optional.of(enderecos.get(1));
		
		BDDMockito.
			given(enderecoService.findByCep("22345678")).
			willReturn(opt);
		
		RestAssuredMockMvc.
			given().mockMvc(mvc).
			param("cep", "22345678").
			when().get("/api/endereco").
			then().
				statusCode(200).
				body("logradouro", equalTo("Rua Teste de Unidade 2")).
				body("numero", equalTo("1202")).
				body("bairro", equalTo("Bairro Teste 2")).
				body("cidade", equalTo("Belo Horizonte")).
				body("uf", equalTo(Uf.MG.getSigla())).
				body("cep", equalTo("22345678"));
	}
	
	/**
	 * Test method for {@link org.otojunior.sample.app.backend.rest.EnderecoRest#findAll()}.
	 * @throws Exception 
	 */
	@Test
	public void testFindById() throws Exception {
		Optional<Endereco> opt = Optional.of(enderecos.get(1));
		
		BDDMockito.
			given(enderecoService.findById(2L)).
			willReturn(opt);
		
		RestAssuredMockMvc.
			given().mockMvc(mvc).
			when().get("/api/endereco/2").
			then().
				statusCode(200).
				body("logradouro", equalTo("Rua Teste de Unidade 2")).
				body("numero", equalTo("1202")).
				body("bairro", equalTo("Bairro Teste 2")).
				body("cidade", equalTo("Belo Horizonte")).
				body("uf", equalTo(Uf.MG.getSigla())).
				body("cep", equalTo("22345678"));
	}
	
	/**
	 * Test method for {@link org.otojunior.sample.app.backend.rest.EnderecoRest#findAll()}.
	 * @throws Exception 
	 */
	@Test
	public void testFindByIdNaoEncontrado() throws Exception {
		Optional<Endereco> opt = Optional.of(enderecos.get(1));
		
		BDDMockito.
			given(enderecoService.findById(2L)).
			willReturn(opt);
		
		RestAssuredMockMvc.
			given().mockMvc(mvc).
			when().get("/api/endereco/9").
			then().statusCode(404);
	}
}
