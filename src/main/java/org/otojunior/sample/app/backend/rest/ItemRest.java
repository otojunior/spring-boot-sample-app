/**
 * 
 */
package org.otojunior.sample.app.backend.rest;

import java.util.List;

import org.otojunior.sample.app.backend.entity.Item;
import org.otojunior.sample.app.backend.exception.HttpNotFoundException;
import org.otojunior.sample.app.backend.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

/**
 * @author otojunior
 *
 */
@RestController
@RequestMapping("/${sample.app.rest.rootpath}/item")
public class ItemRest {
	private static final Logger LOG = LoggerFactory.getLogger(ItemRest.class);
	
	@Autowired
	private ItemService service;
	
	/**
	 * 
	 * @param item
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		service.deleteById(id);
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Item excluído: {}", id);
		}
		
		return ResponseEntity.ok("Item excluído: " + id);
	}
	
	/**
	 * 
	 * @param cpf
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<Item>> findAll() {
		List<Item> items = service.findAll();
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Itens encontrados: {}", items.size());
		}
		
		return (CollectionUtils.isEmpty(items)) ?
			ResponseEntity.noContent().build() : 
			ResponseEntity.ok(items);
	}
	
	/**
	 * 
	 * @param cpf
	 * @return
	 */
	@GetMapping(path="", params="codigo")
	public ResponseEntity<Item> findByCodigo(@RequestParam Long codigo) {
		Item item = service.
			findByCodigo(codigo).
			orElseThrow(() -> new HttpNotFoundException("Item não encontrado. Código=" + codigo));
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Item encontrado. Código={}: {}", codigo, item);
		}
		
		return ResponseEntity.ok(item);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Item> findById(@PathVariable Long id) {
		Item item = service.
			findById(id).
			orElseThrow(() -> new HttpNotFoundException("Item não encontrado. ID=" + id));
			
		if (LOG.isDebugEnabled()) {
			LOG.debug("Item encontrado. ID={}: {}", id, item);
		}

		return ResponseEntity.ok(item);
	}

	/**
	 * 
	 * @param cpf
	 * @return
	 */
	@GetMapping(path="", params="nome")
	public ResponseEntity<Item> findByNome(@RequestParam String nome) {
		Item item = service.
			findByNome(nome).
			orElseThrow(() -> new HttpNotFoundException("Item não encontrado. Nome=" + nome));
			
		if (LOG.isDebugEnabled()) {
			LOG.debug("Item encontrado. Nome={}: {}", nome, item);
		}
			
		return ResponseEntity.ok(item);
	}
	
	/**
	 * 
	 * @param item
	 */
	@PostMapping
	public ResponseEntity<Item> save(@RequestBody Item item) {
		Item salvo = service.save(item);
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("save: {}", salvo);
		}

		return ResponseEntity.ok(salvo);
	}
}
