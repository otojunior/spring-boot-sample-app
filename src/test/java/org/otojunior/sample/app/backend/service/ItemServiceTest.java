/**
 * 
 */
package org.otojunior.sample.app.backend.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.BDDMockito;
import org.otojunior.sample.app.backend.entity.Item;
import org.otojunior.sample.app.backend.entity.ItemTest;
import org.otojunior.sample.app.backend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemServiceTest {
	@MockBean
	private ItemRepository repository;
	
	@Autowired
	private ItemService service;
	
	private final List<Item> MOCK_ITEMS = Arrays.asList(
		ItemTest.of(100L, "Alicate"),
		ItemTest.of(200L, "Martelo"),
		ItemTest.of(300L, "Parafuso"));

	/**
	 * Test method for {@link org.otojunior.sample.app.backend.service.ItemService#findAll()}.
	 */
	@Test
	public void testFindAll() {
		BDDMockito.given(repository.findAll()).willReturn(MOCK_ITEMS);
		assertEquals(3, service.findAll().size());
	}

	/**
	 * Test method for {@link org.otojunior.sample.app.backend.service.ItemService#findByCodigo(java.lang.Long)}.
	 */
	@Test
	public void testFindByCodigo() {
		BDDMockito.given(repository.findByCodigo(100L)).willReturn(Optional.of(MOCK_ITEMS.get(0)));
		BDDMockito.given(repository.findByCodigo(200L)).willReturn(Optional.of(MOCK_ITEMS.get(1)));
		BDDMockito.given(repository.findByCodigo(300L)).willReturn(Optional.of(MOCK_ITEMS.get(2)));
		
		assertEquals("Alicate", service.findByCodigo(100L).get().getNome());
		assertEquals("Martelo", service.findByCodigo(200L).get().getNome());
		assertEquals("Parafuso", service.findByCodigo(300L).get().getNome());
	}
	
	/**
	 * Test method for {@link org.otojunior.sample.app.backend.service.ItemService#findByCodigo(java.lang.Long)}.
	 */
	@Test
	public void testFindByCodigoInexistente() {
		assertFalse(service.findByCodigo(500L).isPresent());
	}

	/**
	 * Test method for {@link org.otojunior.sample.app.backend.service.ItemService#findById(java.lang.Long)}.
	 */
	@Test
	public void testFindById() {
		BDDMockito.given(repository.findById(1L)).willReturn(Optional.of(MOCK_ITEMS.get(0)));
		BDDMockito.given(repository.findById(2L)).willReturn(Optional.of(MOCK_ITEMS.get(1)));
		BDDMockito.given(repository.findById(3L)).willReturn(Optional.of(MOCK_ITEMS.get(2)));
		
		assertEquals("Alicate", service.findById(1L).get().getNome());
		assertEquals("Martelo", service.findById(2L).get().getNome());
		assertEquals("Parafuso", service.findById(3L).get().getNome());
	}
	
	/**
	 * Test method for {@link org.otojunior.sample.app.backend.service.ItemService#findById(java.lang.Long)}.
	 */
	@Test
	public void testFindByIdInexistente() {
		assertFalse(service.findById(500L).isPresent());
	}

	/**
	 * Test method for {@link org.otojunior.sample.app.backend.service.ItemService#findByNome(java.lang.String)}.
	 */
	@Test
	public void testFindByNome() {
		BDDMockito.given(repository.findByNome("Alicate")).willReturn(Optional.of(MOCK_ITEMS.get(0)));
		BDDMockito.given(repository.findByNome("Martelo")).willReturn(Optional.of(MOCK_ITEMS.get(1)));
		BDDMockito.given(repository.findByNome("Parafuso")).willReturn(Optional.of(MOCK_ITEMS.get(2)));
		
		assertEquals(Long.valueOf(100L), service.findByNome("Alicate").get().getCodigo());
		assertEquals(Long.valueOf(200L), service.findByNome("Martelo").get().getCodigo());
		assertEquals(Long.valueOf(300L), service.findByNome("Parafuso").get().getCodigo());
	}
	
	/**
	 * Test method for {@link org.otojunior.sample.app.backend.service.ItemService#findByNome(java.lang.String)}.
	 */
	@Test
	public void testFindByNomeInexistente() {
		assertFalse(service.findByNome("Chave de fenda").isPresent());
	}
}
