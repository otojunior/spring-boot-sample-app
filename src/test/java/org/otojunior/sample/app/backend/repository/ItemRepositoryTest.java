/**
 * 
 */
package org.otojunior.sample.app.backend.repository;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.otojunior.sample.app.backend.entity.Item;
import org.otojunior.sample.app.backend.entity.ItemTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {
	@Autowired private TestEntityManager entityManager;
	@Autowired private ItemRepository repository;
	
	private final List<Item> MOCK_ITEMS = Arrays.asList(
		ItemTest.of(100L, "Alicate"),
		ItemTest.of(200L, "Martelo"),
		ItemTest.of(300L, "Parafuso"));

	/**
	 * 
	 */
	@Before
	public void before() {
		MOCK_ITEMS.forEach(entityManager::persist);
	}
	
	/**
	 * Test method for {@link org.otojunior.sample.app.backend.repository.ItemRepository#findByCodigo(java.lang.Long)}.
	 */
	@Test
	public void testFindByCodigo() {
		assertEquals("Alicate", repository.findByCodigo(100L).get().getNome());
		assertEquals("Martelo", repository.findByCodigo(200L).get().getNome());
		assertEquals("Parafuso", repository.findByCodigo(300L).get().getNome());
	}
	
	/**
	 * Test method for {@link org.otojunior.sample.app.backend.repository.ItemRepository#findByCodigo(java.lang.Long)}.
	 */
	@Test
	public void testFindByCodigoInexistente() {
		assertFalse(repository.findByCodigo(500L).isPresent());
	}

	/**
	 * Test method for {@link org.otojunior.sample.app.backend.repository.ItemRepository#findByNome(java.lang.String)}.
	 */
	@Test
	public void testFindByNome() {
		assertEquals(Long.valueOf(100L), repository.findByNome("Alicate").get().getCodigo());
		assertEquals(Long.valueOf(200L), repository.findByNome("Martelo").get().getCodigo());
		assertEquals(Long.valueOf(300L), repository.findByNome("Parafuso").get().getCodigo());
	}
	
	/**
	 * Test method for {@link org.otojunior.sample.app.backend.repository.ItemRepository#findByNome(java.lang.String)}.
	 */
	@Test
	public void testFindByNomeInexistente() {
		assertFalse(repository.findByNome("Chave de fenda").isPresent());
	}
}
