/**
 * 
 */
package org.otojunior.sample.app.backend.service;

import java.util.List;
import java.util.Optional;

import org.otojunior.sample.app.backend.entity.Item;
import org.otojunior.sample.app.backend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author otojunior
 *
 */
@Service
public class ItemService {
	public static final int NUMERO_PAGINA_DEFAULT = 0;
	public static final int TAMANHO_PAGINA_DEFAULT = 10;
	
	@Autowired
	private ItemRepository repository;
	
	/**
	 * 
	 * @return
	 */
	public List<Item> findAll() {
		return repository.findAll();
	}
	
	/**
	 * 
	 * @return
	 */
	public Page<Item> findAll(Optional<Integer> pagina, Optional<Integer> tamanho) {
		Pageable pageable = PageRequest.of(
			pagina.orElse(NUMERO_PAGINA_DEFAULT),
			tamanho.orElse(TAMANHO_PAGINA_DEFAULT));
		return repository.findAll(pageable);
	}
	
	/**
	 * 
	 * @param cpf
	 * @return
	 */
	public Optional<Item> findByCodigo(Long codigo) {
		return repository.findByCodigo(codigo);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Optional<Item> findById(Long id) {
		return repository.findById(id);
	}
	
	/**
	 * 
	 * @param cpf
	 * @return
	 */
	public Optional<Item> findByNome(String nome) {
		return repository.findByNome(nome);
	}

	/**
	 * 
	 * @param id
	 */
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	/**
	 *
	 * @param item
	 * @return
	 */
	@Transactional
	public Item save(Item item) {
		return repository.save(item);
	}
}
