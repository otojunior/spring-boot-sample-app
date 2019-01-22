/*
 * Copyright 2019 the original author or authors.
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
package org.otojunior.sample.app.backend.repository;

import java.util.Optional;

import org.otojunior.sample.app.backend.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>ItemRepository interface.</p>
 *
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 * @version $Id: $Id
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
	/**
	 * <p>findByCodigo.</p>
	 *
	 * @param codigo a {@link java.lang.Long} object.
	 * @return a {@link java.util.Optional} object.
	 */
	public Optional<Item> findByCodigo(Long codigo);
	/**
	 * <p>findByNome.</p>
	 *
	 * @param nome a {@link java.lang.String} object.
	 * @return a {@link java.util.Optional} object.
	 */
	public Optional<Item> findByNome(String nome);
}
