/**
 * 
 */
package org.otojunior.sample.app.backend.rest;

import java.util.List;

import org.otojunior.sample.app.backend.entity.Cliente;
import org.otojunior.sample.app.backend.exception.HttpNotFoundException;
import org.otojunior.sample.app.backend.service.ClienteService;
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
@RequestMapping("/${sample.app.rest.rootpath}/cliente")
public class ClienteRest {
	private static final Logger LOG = LoggerFactory.getLogger(ClienteRest.class);
	
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
			LOG.debug("Cliente excluído: {}", id);
		}
		
		return ResponseEntity.ok("Cliente excluído: " + id);
	}
	
	/**
	 * 
	 * @param cpf
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> clientes = service.findAll();
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Clientes encontrados: {}", clientes.size());
		}
		
		return (CollectionUtils.isEmpty(clientes)) ?
			ResponseEntity.noContent().build() : 
			ResponseEntity.ok(clientes);
	}
	
	/**
	 * 
	 * @param cpf
	 * @return
	 */
	@GetMapping(path="", params="cpf")
	public ResponseEntity<Cliente> findByCpf(@RequestParam String cpf) {
		Cliente cliente = service.
			findByCpf(cpf).
			orElseThrow(() -> new HttpNotFoundException("Cliente não encontrado. CPF=" + cpf));
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Cliente encontrado. CPF={}: {}", cpf, cliente);
		}
		
		return ResponseEntity.ok(cliente);
	}
	
	/**
	 * 
	 * @param cpf
	 * @return
	 */
	@GetMapping(path="", params="nome")
	public ResponseEntity<Cliente> findByNome(@RequestParam String nome) {
		Cliente cliente = service.
			findByNome(nome).
			orElseThrow(() -> new HttpNotFoundException("Cliente não encontrado. Nome=" + nome));
			
		if (LOG.isDebugEnabled()) {
			LOG.debug("Cliente encontrado. Nome={}: {}", nome, cliente);
		}
			
		return ResponseEntity.ok(cliente);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id) {
		Cliente cliente = service.
			findById(id).
			orElseThrow(() -> new HttpNotFoundException("Cliente não encontrado. ID=" + id));
			
		if (LOG.isDebugEnabled()) {
			LOG.debug("Cliente encontrado. ID={}: {}", id, cliente);
		}

		return ResponseEntity.ok(cliente);
	}
	
	/**
	 * 
	 * @param cliente
	 */
	@PostMapping
	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
		Cliente salvo = service.save(cliente);
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("save: {}", salvo);
		}

		return ResponseEntity.ok(salvo);
	}
}
