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

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.hibernate.envers.Audited;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>Item class.</p>
 *
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 * @version $Id: $Id
 */
@Getter
@Setter
@Entity
@Audited
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
