/*
 * Copyright 2019 Oto Soares Coelho Junior.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
 * <p>Autoridade class.</p>
 *
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @version $Id: $Id
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
