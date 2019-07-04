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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>Usuario class.</p>
 *
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
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
