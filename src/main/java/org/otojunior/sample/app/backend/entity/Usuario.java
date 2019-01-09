/**
 * 
 */
package org.otojunior.sample.app.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>Usuario class.</p>
 *
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 * @version $Id: $Id
 */
@Getter
@Setter
@Entity
@Table(name="users")
public class Usuario extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(name="username", nullable=false, length=50)
	private String login;
	
	@NotNull
	@Column(name="password", nullable=false, length=100)
	private String senha;
	
	@Column(name="enabled", nullable=false)
	private boolean ativo;
}
