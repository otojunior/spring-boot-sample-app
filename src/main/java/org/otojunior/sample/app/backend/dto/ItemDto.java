/**
 * 
 */
package org.otojunior.sample.app.backend.dto;

import org.otojunior.sample.app.backend.entity.Item;
import org.springframework.data.domain.Page;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
@Getter
@Setter
@AllArgsConstructor
public class ItemDto extends Item {
	private static final long serialVersionUID = 1L;

	private Page<Item> page;
}
