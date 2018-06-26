/**
 * 
 */
package org.otojunior.sample.app.backend.rest;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.otojunior.sample.app.backend.entity.Item;
import org.otojunior.sample.app.backend.entity.ItemTest;
import org.otojunior.sample.app.backend.service.ItemService;
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
@WebMvcTest(controllers=ItemRest.class, secure=false)
public class ItemRestTest {
	private final List<Item> MOCK_ITEMS = Arrays.asList(
		ItemTest.of(100L, "Alicate"),
		ItemTest.of(200L, "Martelo"),
		ItemTest.of(300L, "Parafuso"));
	
	@MockBean
	private ItemService service;
	
	@Autowired
	private MockMvc mvc; 

	/**
	 * Test method for {@link org.otojunior.sample.app.backend.rest.ItemRest#deleteById(java.lang.Long)}.
	 */
	@Test
	public void testDeleteById() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.otojunior.sample.app.backend.rest.ItemRest#findAll()}.
	 */
	@Test
	public void testFindAll() {
		BDDMockito.
			given(service.findAll()).
			willReturn(MOCK_ITEMS);
		
		RestAssuredMockMvc.
			given().mockMvc(mvc).
			when().get("/api/item").
			then().
				statusCode(200).root("[0]").
				body("codigo", equalTo("100")).body("nome", equalTo("Alicate")).
				body("codigo", equalTo("200")).body("nome", equalTo("Martelo")).
				body("codigo", equalTo("300")).body("nome", equalTo("Parafuso"));
	}

	/**
	 * Test method for {@link org.otojunior.sample.app.backend.rest.ItemRest#findByCodigo(java.lang.Long)}.
	 */
	@Test
	public void testFindByCodigo() {
		BDDMockito.given(service.findByCodigo(100L)).willReturn(Optional.of(MOCK_ITEMS.get(0)));
		BDDMockito.given(service.findByCodigo(200L)).willReturn(Optional.of(MOCK_ITEMS.get(1)));
		BDDMockito.given(service.findByCodigo(300L)).willReturn(Optional.of(MOCK_ITEMS.get(2)));
		
		Map<Long, String> nomes = new LinkedHashMap<>(3);
		nomes.put(MOCK_ITEMS.get(0).getCodigo(), MOCK_ITEMS.get(0).getNome());
		nomes.put(MOCK_ITEMS.get(1).getCodigo(), MOCK_ITEMS.get(1).getNome());
		nomes.put(MOCK_ITEMS.get(2).getCodigo(), MOCK_ITEMS.get(2).getNome());
		
		for (long i = 100; i <= 300; i += 100) {
			RestAssuredMockMvc.
				given().mockMvc(mvc).
				param("codigo", i).
				when().get("/api/item").
				then().
					statusCode(200).
					body("codigo", equalTo(i)).
					body("nome", equalTo(nomes.get(i)));	
		}
	}

	/**
	 * Test method for {@link org.otojunior.sample.app.backend.rest.ItemRest#findById(java.lang.Long)}.
	 */
	@Test
	public void testFindById() {
		BDDMockito.given(service.findById(1L)).willReturn(Optional.of(MOCK_ITEMS.get(0)));
		BDDMockito.given(service.findById(2L)).willReturn(Optional.of(MOCK_ITEMS.get(1)));
		BDDMockito.given(service.findById(3L)).willReturn(Optional.of(MOCK_ITEMS.get(2)));
		
		Map<Long, String> nomes = new LinkedHashMap<>(3);
		nomes.put(1L, MOCK_ITEMS.get(0).getNome());
		nomes.put(2L, MOCK_ITEMS.get(1).getNome());
		nomes.put(3L, MOCK_ITEMS.get(2).getNome());
		
		for (long i = 1; i <= 3; i++) {
			RestAssuredMockMvc.
				given().mockMvc(mvc).
				when().get("/api/item/" + i).
				then().
					statusCode(200).
					body("codigo", equalTo(i * 100)).
					body("nome", equalTo(nomes.get(i)));	
		}
	}

	/**
	 * Test method for {@link org.otojunior.sample.app.backend.rest.ItemRest#findByNome(java.lang.String)}.
	 */
	@Test
	public void testFindByNome() {
		BDDMockito.given(service.findByNome("Alicate")).willReturn(Optional.of(MOCK_ITEMS.get(0)));
		BDDMockito.given(service.findByNome("Martelo")).willReturn(Optional.of(MOCK_ITEMS.get(1)));
		BDDMockito.given(service.findByNome("Parafuso")).willReturn(Optional.of(MOCK_ITEMS.get(2)));
		
		Map<Long, String> nomes = new LinkedHashMap<>(3);
		nomes.put(MOCK_ITEMS.get(0).getCodigo(), MOCK_ITEMS.get(0).getNome());
		nomes.put(MOCK_ITEMS.get(1).getCodigo(), MOCK_ITEMS.get(1).getNome());
		nomes.put(MOCK_ITEMS.get(2).getCodigo(), MOCK_ITEMS.get(2).getNome());
		
		RestAssuredMockMvc.
			given().mockMvc(mvc).
			param("nome", "Alicate").
			when().get("/api/item").
			then().
				statusCode(200).
				body("codigo", equalTo(100L)).
				body("nome", equalTo(nomes.get(0)));
		
		RestAssuredMockMvc.
			given().mockMvc(mvc).
			param("nome", "Martelo").
			when().get("/api/item").
			then().
				statusCode(200).
				body("codigo", equalTo(200L)).
				body("nome", equalTo(nomes.get(1)));
		
		RestAssuredMockMvc.
			given().mockMvc(mvc).
			param("nome", "Parafuso").
			when().get("/api/item").
			then().
				statusCode(200).
				body("codigo", equalTo(300L)).
				body("nome", equalTo(nomes.get(2)));
	}

	/**
	 * Test method for {@link org.otojunior.sample.app.backend.rest.ItemRest#save(org.otojunior.sample.app.backend.entity.Item)}.
	 */
	@Test
	public void testSave() {
		fail("Not yet implemented");
	}

}
