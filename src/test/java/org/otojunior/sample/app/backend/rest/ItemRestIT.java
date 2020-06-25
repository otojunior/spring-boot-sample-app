/**
 * 
 */
package org.otojunior.sample.app.backend.rest;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class ItemRestIT {
	private static final String[] NOMES = { "Alicate", "Martelo", "Parafuso" };
	
	@Autowired
	private MockMvc mvc; 

	/**
	 * Test method for {@link org.otojunior.sample.app.backend.rest.ItemRest#deleteById(java.lang.Long)}.
	 * @throws Exception 
	 */
	@Test
	@Transactional
	public void testDeleteById() throws Exception {
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
		mvc.perform(get("/api/item"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("[0].codigo", is(100))).andExpect(jsonPath("[0].nome", is(NOMES[0])))
			.andExpect(jsonPath("[1].codigo", is(150))).andExpect(jsonPath("[1].nome", is(NOMES[1])))
			.andExpect(jsonPath("[2].codigo", is(200))).andExpect(jsonPath("[2].nome", is(NOMES[2])));
	}
	
	/**
	 * Test method for {@link org.otojunior.sample.app.backend.rest.ItemRest#findByCodigo(java.lang.Long)}.
	 * @throws Exception 
	 */
	@Test
	public void testFindByCodigo() throws Exception {
		for (int i = 100, n = 0; i <= 200 ; i+= 50, n++) {
			mvc.perform(get("/api/item")
					.param("codigo", String.valueOf(i)))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.codigo", is(i)))
				.andExpect(jsonPath("$.nome", is(NOMES[n])));
		}
	}
	
	/**
	 * Test method for {@link org.otojunior.sample.app.backend.rest.ItemRest#findByCodigo(java.lang.Long)}.
	 * @throws Exception 
	 */
	@Test
	public void testFindByCodigoNaoExistente() throws Exception {
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
		for (int i = 1; i <= 3; i++) {
			mvc.perform(get("/api/item/" + i))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.codigo", is(100 + (50 * (i-1)))))
				.andExpect(jsonPath("$.nome", is(NOMES[i-1])));
		}
	}
	
	/**
	 * Test method for {@link org.otojunior.sample.app.backend.rest.ItemRest#findById(java.lang.Long)}.
	 * @throws Exception 
	 */
	@Test
	public void testFindByIdNaoExistente() throws Exception {
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
		for (int i = 1; i <= 3; i++) {
			mvc.perform(get("/api/item")
					.param("nome", NOMES[i-1]))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.codigo", is(100 + (50 * (i-1)))))
				.andExpect(jsonPath("$.nome", is(NOMES[i-1])));
		}
	}
	
	/**
	 * Test method for {@link org.otojunior.sample.app.backend.rest.ItemRest#findByNome(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testFindByNomeNaoExistente() throws Exception {
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
	@Transactional
	public void testSave() throws Exception {
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
