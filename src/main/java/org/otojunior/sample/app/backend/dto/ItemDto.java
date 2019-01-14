/**
 * 
 */
package org.otojunior.sample.app.backend.dto;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.otojunior.sample.app.backend.entity.Item;
import org.springframework.data.domain.Page;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>ItemDto class.</p>
 *
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 * @version $Id: $Id
 */
@Getter
@Setter
public class ItemDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long codigo;
	private String nome;
	private Page<Item> page;

	/**
	 * Obtem um item a partir de um ItemDTO.
	 *
	 * @return Entidade Item.
	 */
	public Item toItem() {
		Item item = new Item();
		item.setCodigo(this.codigo);
		item.setNome(StringUtils.isNotBlank(nome) ? nome : null);
		return item;
	}
}
