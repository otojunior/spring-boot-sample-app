/**
 * 
 */
package org.otojunior.sample.app.backend.entity;

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
		item.setPreco(Math.random());
		return item;
	}
}
