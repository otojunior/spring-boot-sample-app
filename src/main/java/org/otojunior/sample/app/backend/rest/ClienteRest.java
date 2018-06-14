/**
 * 
 */
package org.otojunior.sample.app.backend.rest;

import java.util.List;

import org.otojunior.sample.app.backend.entity.Cliente;
import org.otojunior.sample.app.backend.service.ClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/${sample.app.rest.rootpath}/cliente")
public class ClienteRest {
	private final static Logger LOG = LoggerFactory.getLogger(ClienteRest.class);
	
	@Autowired
	private ClienteService service;
	
	/**
	 * 
	 * @param cliente
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		service.deleteById(id);
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("delete: " + id);
		}
		
		return ResponseEntity.ok("deleted: " + id);
	}
	
	/**
	 * 
	 * @param cpf
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> all = service.findAll();
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("findAll: " + all.size());
		}
		
		return CollectionUtils.isEmpty(all) ?
			ResponseEntity.noContent().build() :
			ResponseEntity.ok(all);
	}
	
	/**
	 * 
	 * @param cpf
	 * @return
	 */
	@GetMapping(path="", params="cpf")
	public ResponseEntity<Cliente> findByCpf(@RequestParam String cpf) {
		Cliente cliente = service.findByCpf(cpf);
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("findByNome: " + cpf + " = " + cliente);
		}
		
		return (cliente == null) ?
			ResponseEntity.notFound().build() :
			ResponseEntity.ok(cliente);
	}
	
	/**
	 * 
	 * @param cpf
	 * @return
	 */
	@GetMapping(path="", params="nome")
	public ResponseEntity<Cliente> findByNome(@RequestParam String nome) {
		Cliente cliente = service.findByNome(nome);
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("findByNome: " + nome + " = " + cliente);
		}
		
		return (cliente == null) ?
			new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND) :
			ResponseEntity.ok(cliente);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id) {
		Cliente cliente = service.findById(id);
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("findById: " + id + " = " + cliente);
		}
		
		return (cliente == null) ?
			ResponseEntity.notFound().build() :
			ResponseEntity.ok(cliente);
	}
	
	/**
	 * 
	 * @param cliente
	 */
	@PostMapping
	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
		Cliente salvo = service.save(cliente);
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("save: " + cliente);
		}
		
		return ResponseEntity.ok(salvo);
	}
}
