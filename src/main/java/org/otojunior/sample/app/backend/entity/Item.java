/**
 * 
 */
package org.otojunior.sample.app.backend.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded=true, callSuper=true)
@ToString(callSuper=true)
@Entity
public class Item extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(nullable=false, unique=true)
	private Long codigo;
	
	@NotNull
	@Column(nullable=false, length=20)
	private String nome;
	
	@NotNull
	@Column(nullable=false, precision=15, scale=2)
	private BigDecimal preco;
}
