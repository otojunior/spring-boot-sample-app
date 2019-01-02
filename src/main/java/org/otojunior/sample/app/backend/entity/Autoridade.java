/**
 * 
 */
package org.otojunior.sample.app.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
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
@Table(
	name="authorities",
	uniqueConstraints=@UniqueConstraint(
		name="ix_auth_username",
		columnNames= {"username","authority"}))
public class Autoridade extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@NotNull
	@ManyToOne
	@JoinColumn(name="username", referencedColumnName="username")
	private Usuario Usuario;
	
	@NotNull
	@Column(name="authority", nullable=false, length=50)
	private String autoridade;
}
