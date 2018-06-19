/**
 * 
 */
package org.otojunior.sample.app.backend.rest;

import java.util.List;
import java.util.Optional;

import org.otojunior.sample.app.backend.entity.Cliente;
import org.otojunior.sample.app.backend.exception.ClienteNaoEncontradoException;
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
		ResponseEntity<List<Cliente>> retorno = null;
		if (!CollectionUtils.isEmpty(clientes)) {
			LOG.debug("Clientes encontrados: {}", clientes.size());
			retorno = ResponseEntity.ok(clientes);
		} else {
			LOG.warn("Nenhum cliente encontrado");
			retorno = ResponseEntity.noContent().build();
		}
		return retorno;
	}
	
	/**
	 * 
	 * @param cpf
	 * @return
	 */
	@GetMapping(path="", params="cpf")
	public ResponseEntity<Cliente> findByCpf(@RequestParam String cpf) {
		Optional<Cliente> cliente = service.findByCpf(cpf);
		ResponseEntity<Cliente> retorno = null;
		if (cliente.isPresent()) {
			LOG.debug("Cliente encontrado. CPF={}: {}", cpf, cliente.get());
			retorno = ResponseEntity.ok(cliente.get());
		} else {
			LOG.warn("Cliente não encontrado. CPF={}", cpf);
			throw new ClienteNaoEncontradoException("CPF=", cpf);
		} 
		return retorno;
	}
	
	/**
	 * 
	 * @param cpf
	 * @return
	 */
	@GetMapping(path="", params="nome")
	public ResponseEntity<Cliente> findByNome(@RequestParam String nome) {
		Optional<Cliente> cliente = service.findByNome(nome);
		ResponseEntity<Cliente> retorno = null;
		if (cliente.isPresent()) {
			LOG.debug("Cliente encontrado. Nome={}: {}", nome, cliente.get());
			retorno = ResponseEntity.ok(cliente.get());
		} else {
			LOG.warn("Cliente não encontrado. Nome={}", nome);
			throw new ClienteNaoEncontradoException("Nome=", nome);
		} 
		return retorno;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id) {
		Optional<Cliente> cliente = service.findById(id);
		ResponseEntity<Cliente> retorno = null;
		if (cliente.isPresent()) {
			LOG.debug("Cliente encontrado. Id={}: {}", id, cliente.get());
			retorno = ResponseEntity.ok(cliente.get());
		} else {
			LOG.warn("Cliente não encontrado. Id={}", id);
			throw new ClienteNaoEncontradoException("ID=", id.toString());
		} 
		return retorno;
	}
	
	/**
	 * 
	 * @param cliente
	 */
	@PostMapping
	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
		Cliente salvo = service.save(cliente);
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("save: {}", cliente);
		}
		
		return ResponseEntity.ok(salvo);
	}
}
