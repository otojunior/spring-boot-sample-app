/**
 * 
 */
package org.otojunior.sample.app.backend.rest;

import java.util.List;

import org.otojunior.sample.app.backend.entity.Endereco;
import org.otojunior.sample.app.backend.exception.HttpNotFoundException;
import org.otojunior.sample.app.backend.service.EnderecoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author otojunior
 *
 */
@RestController
@RequestMapping("/${sample.app.rest.rootpath}/endereco")
public class EnderecoRest {
	private static final Logger LOG = LoggerFactory.getLogger(EnderecoRest.class);
	
	@Autowired
	private EnderecoService service;
	
	/**
	 * 
	 * @param cpf
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<Endereco>> findAll() {
		List<Endereco> enderecos = service.findAll();
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Endereços encontrados: {}", enderecos.size());
		}
		
		return (CollectionUtils.isEmpty(enderecos)) ?
			ResponseEntity.noContent().build() : 
			ResponseEntity.ok(enderecos);
	}
	
	/**
	 * 
	 * @param cpf
	 * @return
	 */
	@GetMapping(path="", params="cep")
	public ResponseEntity<Endereco> findByCep(@RequestParam String cep) {
		Endereco endereco = service.
			findByCep(cep).
			orElseThrow(() -> new HttpNotFoundException("Endereço não encontrado. CEP=" + cep));
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Endereço encontrado. CEP={}: {}", cep, endereco);
		}
		
		return ResponseEntity.ok(endereco);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Endereco> findById(@PathVariable Long id) {
		Endereco endereco = service.
			findById(id).
			orElseThrow(() -> new HttpNotFoundException("Endereço não encontrado. ID=" + id));
			
		if (LOG.isDebugEnabled()) {
			LOG.debug("Endereço encontrado. ID={}: {}", id, endereco);
		}

		return ResponseEntity.ok(endereco);
	}
}
