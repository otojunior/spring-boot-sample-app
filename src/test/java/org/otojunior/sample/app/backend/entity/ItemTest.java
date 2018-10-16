/**
 * 
 */
package org.otojunior.sample.app.backend.entity;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
public class ItemTest {
	/**
	 * 
	 * @param codigo
	 * @param nome
	 * @return
	 */
	public static Item of(Long codigo, String nome) {
		Item item = new Item();
		item.setCodigo(codigo);
		item.setNome(nome);
		item.setPreco(BigDecimal.valueOf(Math.random()));
		return item;
	}
	
	/**
	 * 
	 */
	@Test
	public void testAccessors() {
		Item item = of(100L, "Teste");
		item.setPreco(BigDecimal.valueOf(1.25));
		assertEquals(100L, item.getCodigo().longValue());
		assertEquals("Teste", item.getNome());
		assertEquals(1.25, item.getPreco().doubleValue(), 0);
	}
}
