/**
 * 
 */
package org.otojunior.sample.app.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>Arquivo class.</p>
 *
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 * @version $Id: $Id
 */
@Getter
@Setter
@Entity
public class Arquivo extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(nullable=false, unique=true)
	private Long codigo;
	
	@NotNull
	@Column(nullable=false, length=20)
	private String nome;

	@NotNull
	@Column(nullable=false)
	private Long tamanho;
	
	@Lob
	@NotNull
	@Column(nullable=false)
	private byte[] conteudo;
}
