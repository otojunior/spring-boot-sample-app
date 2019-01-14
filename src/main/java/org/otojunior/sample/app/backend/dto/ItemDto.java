/**
 * 
 */
package org.otojunior.sample.app.backend.dto;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

import java.io.Serializable;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
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
	private Integer pagina = 0;
	private Integer ultimaPagina = 0;
	
	private Page<Item> page;

	/**
	 * 
	 * @param operacao
	 * @return
	 */
	public int getPagina(Optional<String> operacao) {
		if (operacao.isPresent()) {
			switch (operacao.get()) {
				case "<":
					this.pagina = (this.pagina > 0) ? (this.pagina - 1) : 0;
					break;
				case ">":
					this.pagina++;
					break;
				case "<<":
					this.pagina = 0;
					break;
				case ">>":
					this.pagina = ultimaPagina;
					break;
			}
		}
		return this.pagina;
	}

	/**
	 * Obtem um item a partir de um ItemDTO.
	 *
	 * @return Entidade Item.
	 */
	public Item toItem() {
		Item item = new Item();
		item.setCodigo(codigo);
		item.setNome(StringUtils.isNotBlank(nome) ? nome : null);
		return item;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
	}
}
