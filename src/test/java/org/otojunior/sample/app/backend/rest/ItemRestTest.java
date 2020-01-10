/**
 * 
 */
package org.otojunior.sample.app.backend.rest;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.otojunior.sample.app.backend.entity.Item;
import org.otojunior.sample.app.backend.entity.ItemTest;
import org.otojunior.sample.app.backend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@WebMvcTest(
	controllers=ItemRest.class,
	secure=false,
	excludeFilters=@ComponentScan.Filter(
		type=FilterType.REGEX,
		pattern="org.otojunior.sample.app.frontend.advice.*"))
public class ItemRestTest {
	private static final String[] NOMES = { "Alicate", "Martelo", "Parafuso" };
	
	private static final List<Item> MOCK_ITEMS = Arrays.asList(
		ItemTest.of(100L, NOMES[0]),
		ItemTest.of(200L, NOMES[1]),
		ItemTest.of(300L, NOMES[2]));
	
	@MockBean
	private ItemService service;
	
	@Autowired
	private MockMvc mvc; 

	/**
	 * Test method for {@link org.otojunior.sample.app.backend.rest.ItemRest#deleteById(java.lang.Long)}.
	 * @throws Exception 
	 */
	@Test
	public void testDeleteById() throws Exception {
		doNothing().when(service).deleteById(anyLong());
		
		mvc.perform(delete("/api/item/1"))
			.andDo(print())
			.andExpect(status().isOk());
	}

	/**
	 * Test method for {@link org.otojunior.sample.app.backend.rest.ItemRest#findAll()}.
	 * @throws Exception 
	 */
	@Test
	public void testFindAll() throws Exception {
		given(service.findAll()).willReturn(MOCK_ITEMS);

		mvc.perform(get("/api/item"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("[0].codigo", is(100))).andExpect(jsonPath("[0].nome", is(NOMES[0])))
			.andExpect(jsonPath("[1].codigo", is(200))).andExpect(jsonPath("[1].nome", is(NOMES[1])))
			.andExpect(jsonPath("[2].codigo", is(300))).andExpect(jsonPath("[2].nome", is(NOMES[2])));
	}
	
	/**
	 * Test method for {@link org.otojunior.sample.app.backend.rest.ItemRest#findAll()}.
	 * @throws Exception 
	 */
	@Test
	public void testFindAllNoContent() throws Exception {
		given(service.findAll()).willReturn(Collections.emptyList());
		
		mvc.perform(get("/api/item"))
			.andDo(print())
			.andExpect(status().isNoContent());
	}
	
	/**
	 * Test method for {@link org.otojunior.sample.app.backend.rest.ItemRest#findByCodigo(java.lang.Long)}.
	 * @throws Exception 
	 */
	@Test
	public void testFindByCodigo() throws Exception {
		given(service.findByCodigo(100L)).willReturn(Optional.of(MOCK_ITEMS.get(0)));
		given(service.findByCodigo(200L)).willReturn(Optional.of(MOCK_ITEMS.get(1)));
		given(service.findByCodigo(300L)).willReturn(Optional.of(MOCK_ITEMS.get(2)));
		
		for (int i = 100; i <= 300 ; i+= 100) {
			mvc.perform(get("/api/item")
					.param("codigo", String.valueOf(i)))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.codigo", is(i)))
				.andExpect(jsonPath("$.nome", is(NOMES[i/100-1])));
		}
	}
	
	/**
	 * Test method for {@link org.otojunior.sample.app.backend.rest.ItemRest#findByCodigo(java.lang.Long)}.
	 * @throws Exception 
	 */
	@Test
	public void testFindByCodigoNaoExistente() throws Exception {
		given(service.findByCodigo(100L)).willReturn(Optional.of(MOCK_ITEMS.get(0)));
		given(service.findByCodigo(200L)).willReturn(Optional.of(MOCK_ITEMS.get(1)));
		given(service.findByCodigo(300L)).willReturn(Optional.of(MOCK_ITEMS.get(2)));
		
		mvc.perform(get("/api/item")
				.param("codigo", "999"))
			.andDo(print())
			.andExpect(status().isNotFound());
	}

	/**
	 * Test method for {@link org.otojunior.sample.app.backend.rest.ItemRest#findById(java.lang.Long)}.
	 * @throws Exception 
	 */
	@Test
	public void testFindById() throws Exception {
		given(service.findById(1L)).willReturn(Optional.of(MOCK_ITEMS.get(0)));
		given(service.findById(2L)).willReturn(Optional.of(MOCK_ITEMS.get(1)));
		given(service.findById(3L)).willReturn(Optional.of(MOCK_ITEMS.get(2)));
		
		for (int i = 1; i <= 3; i++) {
			mvc.perform(get("/api/item/" + i))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.codigo", is(i * 100)))
				.andExpect(jsonPath("$.nome", is(NOMES[i-1])));
		}
	}
	
	/**
	 * Test method for {@link org.otojunior.sample.app.backend.rest.ItemRest#findById(java.lang.Long)}.
	 * @throws Exception 
	 */
	@Test
	public void testFindByIdNaoExistente() throws Exception {
		given(service.findById(1L)).willReturn(Optional.of(MOCK_ITEMS.get(0)));
		given(service.findById(2L)).willReturn(Optional.of(MOCK_ITEMS.get(1)));
		given(service.findById(3L)).willReturn(Optional.of(MOCK_ITEMS.get(2)));
		
		mvc.perform(get("/api/item/999"))
			.andDo(print())
			.andExpect(status().isNotFound());
	}

	/**
	 * Test method for {@link org.otojunior.sample.app.backend.rest.ItemRest#findByNome(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testFindByNome() throws Exception {
		given(service.findByNome("Alicate")).willReturn(Optional.of(MOCK_ITEMS.get(0)));
		given(service.findByNome("Martelo")).willReturn(Optional.of(MOCK_ITEMS.get(1)));
		given(service.findByNome("Parafuso")).willReturn(Optional.of(MOCK_ITEMS.get(2)));
		
		for (int i = 1; i <= 3; i++) {
			mvc.perform(get("/api/item")
					.param("nome", NOMES[i-1]))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.codigo", is(i * 100)))
				.andExpect(jsonPath("$.nome", is(NOMES[i-1])));
		}
	}
	
	/**
	 * Test method for {@link org.otojunior.sample.app.backend.rest.ItemRest#findByNome(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testFindByNomeNaoExistente() throws Exception {
		given(service.findByNome("Alicate")).willReturn(Optional.of(MOCK_ITEMS.get(0)));
		given(service.findByNome("Martelo")).willReturn(Optional.of(MOCK_ITEMS.get(1)));
		given(service.findByNome("Parafuso")).willReturn(Optional.of(MOCK_ITEMS.get(2)));
		
		mvc.perform(get("/api/item")
				.param("nome", "xxxyyyzzz"))
			.andDo(print())
			.andExpect(status().isNotFound());
	}

	/**
	 * Test method for {@link org.otojunior.sample.app.backend.rest.ItemRest#save(org.otojunior.sample.app.backend.entity.Item)}.
	 * @throws Exception 
	 */
	@Test
	public void testSave() throws Exception {
		doReturn(new Item()).when(service).save(any(Item.class));
		
		Map<String, Object>  jsonAsMap = new LinkedHashMap<>();
		jsonAsMap.put("codigo", 1000);
		jsonAsMap.put("nome", "Teste");
		jsonAsMap.put("preco", 1.25);
		
		String json = new ObjectMapper().writeValueAsString(jsonAsMap);
		
		mvc.perform(post("/api/item")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
			.andDo(print())
			.andExpect(status().isOk());
	}
}
