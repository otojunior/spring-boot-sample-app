/**
 * 
 */
package org.otojunior.sample.app.backend.service;

import java.util.List;
import java.util.Optional;

import org.otojunior.sample.app.backend.entity.Item;
import org.otojunior.sample.app.backend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author otojunior
 *
 */
@Service
@Transactional(readOnly=true)
public class ItemService {
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
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	/**
	 * 
	 * @param item
	 * @return
	 */
	public Item save(Item item) {
		return repository.save(item);
	}
}
