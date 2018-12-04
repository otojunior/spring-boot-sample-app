/**
 * 
 */
package org.otojunior.sample.app.backend.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
@Getter
@Setter
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