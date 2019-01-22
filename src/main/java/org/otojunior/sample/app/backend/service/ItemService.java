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
package org.otojunior.sample.app.backend.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.otojunior.sample.app.backend.dto.ItemDto;
import org.otojunior.sample.app.backend.entity.Item;
import org.otojunior.sample.app.backend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>ItemService class.</p>
 *
 * @author otojunior
 * @version $Id: $Id
 */
@Service
public class ItemService {
	/** Constant <code>NUMERO_PAGINA_DEFAULT=0</code> */
	public static final int NUMERO_PAGINA_DEFAULT = 0;
	/** Constant <code>TAMANHO_PAGINA_DEFAULT=10</code> */
	public static final int TAMANHO_PAGINA_DEFAULT = 5;
	
	@Autowired
	private ItemRepository repository;
	
	/**
	 * <p>findAll.</p>
	 *
	 * @return a {@link java.util.List} object.
	 */
	public List<Item> findAll() {
		return repository.findAll();
	}
	
	/**
	 * <p>findAll.</p>
	 *
	 * @return a {@link org.springframework.data.domain.Page} object.
	 * @param itemdto a {@link org.otojunior.sample.app.backend.dto.ItemDto} object.
	 * @param operacao a {@link java.util.Optional} object.
	 */
	public Page<Item> findAll(ItemDto itemdto, Optional<String> operacao) {
		Item item = itemdto.toItem();
		
		ExampleMatcher matcher = ExampleMatcher.matching().
			withMatcher("codigo", match -> match.exact()).
			withMatcher("nome", match -> match.startsWith().ignoreCase());
		
		Example<Item> example = Example.of(item, matcher);
		
		Pageable pageable = PageRequest.of(
			itemdto.getPagina(operacao),
			TAMANHO_PAGINA_DEFAULT);
		
		Page<Item> page = repository.findAll(example, pageable);
		itemdto.setUltimaPagina(page.getTotalPages()-1);
		
		return page;
	}
	
	/**
	 * <p>findByCodigo.</p>
	 *
	 * @param codigo a {@link java.lang.Long} object.
	 * @return a {@link java.util.Optional} object.
	 */
	public Optional<Item> findByCodigo(Long codigo) {
		return repository.findByCodigo(codigo);
	}
	
	/**
	 * <p>findById.</p>
	 *
	 * @param id a {@link java.lang.Long} object.
	 * @return a {@link java.util.Optional} object.
	 */
	public Optional<Item> findById(Long id) {
		return repository.findById(id);
	}
	
	/**
	 * <p>findByNome.</p>
	 *
	 * @param nome a {@link java.lang.String} object.
	 * @return a {@link java.util.Optional} object.
	 */
	public Optional<Item> findByNome(String nome) {
		return repository.findByNome(nome);
	}

	/**
	 * <p>deleteById.</p>
	 *
	 * @param id a {@link java.lang.Long} object.
	 */
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	/**
	 * <p>save.</p>
	 *
	 * @param item a {@link org.otojunior.sample.app.backend.entity.Item} object.
	 * @return a {@link org.otojunior.sample.app.backend.entity.Item} object.
	 */
	@Transactional
	public Item save(Item item) {
		return repository.save(item);
	}
	
	/**
	 * <p>cargaInicialExtra.</p>
	 */
	@Transactional
	@PostConstruct
	public void cargaInicialExtra() {
		final int N = 217;
		final List<Item> ITENS = new ArrayList<>(N);
		for (int i = 1; i <= N; i++) {
			Item item = new Item();
			item.setCodigo(Long.valueOf(1000+i));
			item.setNome("Item " + i);
			item.setPreco(BigDecimal.valueOf(i));
			ITENS.add(item);
		}
		repository.saveAll(ITENS);
	}
}
