/**
 * 
 */
package org.otojunior.sample.app.backend.rest;

import java.util.List;

import org.otojunior.sample.app.backend.entity.Cliente;
import org.otojunior.sample.app.backend.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
@RequestMapping("/api")
public class ClienteRest {
	@Autowired
	private ClienteService service;
	
	/**
	 * 
	 * @param cliente
	 */
	@DeleteMapping("/cliente/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		ResponseEntity<?> response = null;
		try {
			service.deleteById(id);
			response = ResponseEntity.noContent().build();
		} catch (EmptyResultDataAccessException e) {
			response = ResponseEntity.notFound().build();
		}
		return response;
	}
	
	/**
	 * 
	 * @param cpf
	 * @return
	 */
	@GetMapping("/clientes")
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> all = service.findAll();
		return CollectionUtils.isEmpty(all) ?
			ResponseEntity.noContent().build() :
			ResponseEntity.ok(all);
	}
	
	/**
	 * 
	 * @param cpf
	 * @return
	 */
	@GetMapping("/cliente")
	public ResponseEntity<Cliente> findByCpf(@RequestParam String cpf) {
		Cliente cliente = service.findByCpf(cpf);
		return (cliente == null) ?
			ResponseEntity.noContent().build() :
			ResponseEntity.ok(cliente);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/cliente/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id) {
		Cliente cliente = service.findById(id);
		return (cliente == null) ?
			ResponseEntity.noContent().build() :
			ResponseEntity.ok(cliente);
	}
	
	/**
	 * 
	 * @param cliente
	 */
	@PostMapping("/cliente")
	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
		Cliente salvo = service.save(cliente);
		return ResponseEntity.ok(salvo);
	}
}
