/**
 * 
 */
package org.otojunior.sample.app.backend.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {
	@Autowired
	private ItemRepository repository;
	
	/**
	 * Test method for {@link org.otojunior.sample.app.backend.repository.ItemRepository#findByCodigo(java.lang.Long)}.
	 */
	@Test
	public void testFindByCodigo() {
		assertEquals("Alicate", repository.findByCodigo(100L).get().getNome());
		assertEquals("Martelo", repository.findByCodigo(150L).get().getNome());
		assertEquals("Parafuso", repository.findByCodigo(200L).get().getNome());
	}
	
	/**
	 * Test method for {@link org.otojunior.sample.app.backend.repository.ItemRepository#findByCodigo(java.lang.Long)}.
	 */
	@Test
	public void testFindByCodigoInexistente() {
		assertFalse(repository.findByCodigo(Long.MAX_VALUE).isPresent());
	}

	/**
	 * Test method for {@link org.otojunior.sample.app.backend.repository.ItemRepository#findByNome(java.lang.String)}.
	 */
	@Test
	public void testFindByNome() {
		assertEquals(Long.valueOf(100L), repository.findByNome("Alicate").get().getCodigo());
		assertEquals(Long.valueOf(150L), repository.findByNome("Martelo").get().getCodigo());
		assertEquals(Long.valueOf(200L), repository.findByNome("Parafuso").get().getCodigo());
	}
	
	/**
	 * Test method for {@link org.otojunior.sample.app.backend.repository.ItemRepository#findByNome(java.lang.String)}.
	 */
	@Test
	public void testFindByNomeInexistente() {
		assertFalse(repository.findByNome("Chave de fenda").isPresent());
	}
}
