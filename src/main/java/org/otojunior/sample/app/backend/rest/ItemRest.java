/**
 * 
 */
package org.otojunior.sample.app.backend.rest;

import java.util.List;

import org.otojunior.sample.app.backend.entity.Item;
import org.otojunior.sample.app.backend.exception.HttpNotFoundException;
import org.otojunior.sample.app.backend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>ItemRest class.</p>
 *
 * @author otojunior
 * @version $Id: $Id
 */
@Slf4j
@RestController
@RequestMapping("/${sample.app.rest.rootpath}/item")
public class ItemRest {
	@Autowired
	private ItemService service;
	
	/**
	 * <p>deleteById.</p>
	 *
	 * @param id a {@link java.lang.Long} object.
	 * @return a {@link org.springframework.http.ResponseEntity} object.
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		service.deleteById(id);
		
		if (log.isDebugEnabled()) {
			log.debug("Item excluído: {}", id);
		}
		
		return ResponseEntity.ok("Item excluído: " + id);
	}
	
	/**
	 * <p>findAll.</p>
	 *
	 * @return a {@link org.springframework.http.ResponseEntity} object.
	 */
	@GetMapping
	public ResponseEntity<List<Item>> findAll() {
		List<Item> items = service.findAll();
		
		if (log.isDebugEnabled()) {
			log.debug("Itens encontrados: {}", items.size());
		}
		
		return (CollectionUtils.isEmpty(items)) ?
			ResponseEntity.noContent().build() : 
			ResponseEntity.ok(items);
	}
	
	/**
	 * <p>findByCodigo.</p>
	 *
	 * @param codigo a {@link java.lang.Long} object.
	 * @return a {@link org.springframework.http.ResponseEntity} object.
	 */
	@GetMapping(path="", params="codigo")
	public ResponseEntity<Item> findByCodigo(@RequestParam Long codigo) {
		Item item = service.
			findByCodigo(codigo).
			orElseThrow(() -> new HttpNotFoundException("Item não encontrado. Código=" + codigo));
		
		if (log.isDebugEnabled()) {
			log.debug("Item encontrado. Código={}: {}", codigo, item);
		}
		
		return ResponseEntity.ok(item);
	}
	
	/**
	 * <p>findById.</p>
	 *
	 * @param id a {@link java.lang.Long} object.
	 * @return a {@link org.springframework.http.ResponseEntity} object.
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Item> findById(@PathVariable Long id) {
		Item item = service.
			findById(id).
			orElseThrow(() -> new HttpNotFoundException("Item não encontrado. ID=" + id));
			
		if (log.isDebugEnabled()) {
			log.debug("Item encontrado. ID={}: {}", id, item);
		}

		return ResponseEntity.ok(item);
	}

	/**
	 * <p>findByNome.</p>
	 *
	 * @param nome a {@link java.lang.String} object.
	 * @return a {@link org.springframework.http.ResponseEntity} object.
	 */
	@GetMapping(path="", params="nome")
	public ResponseEntity<Item> findByNome(@RequestParam String nome) {
		Item item = service.
			findByNome(nome).
			orElseThrow(() -> new HttpNotFoundException("Item não encontrado. Nome=" + nome));
			
		if (log.isDebugEnabled()) {
			log.debug("Item encontrado. Nome={}: {}", nome, item);
		}
			
		return ResponseEntity.ok(item);
	}
	
	/**
	 * <p>save.</p>
	 *
	 * @param item a {@link org.otojunior.sample.app.backend.entity.Item} object.
	 * @return a {@link org.springframework.http.ResponseEntity} object.
	 */
	@PostMapping
	public ResponseEntity<Item> save(@RequestBody Item item) {
		Item salvo = service.save(item);
		
		if (log.isDebugEnabled()) {
			log.debug("save: {}", salvo);
		}

		return ResponseEntity.ok(salvo);
	}
}
