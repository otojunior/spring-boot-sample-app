/**
 * 
 */
package org.otojunior.sample.app.backend.rest;

import java.util.List;

import org.otojunior.sample.app.backend.entity.Cliente;
import org.otojunior.sample.app.backend.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author otojunior
 *
 */
@RestController
@RequestMapping("/api/cliente")
public class ClienteRest {
	@Autowired
	private ClienteService service;
	
	/**
	 * 
	 * @param cpf
	 * @return
	 */
	@GetMapping("/find")
	public List<Cliente> findAll() {
		return service.findAll();
	}
	
	/**
	 * 
	 * @param cpf
	 * @return
	 */
	@GetMapping("/find/cpf/{cpf}")
	public Cliente findByCpf(@PathVariable String cpf) {
		return service.findByCpf(cpf);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/find/id/{id}")
	public Cliente findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	/**
	 * 
	 * @param cliente
	 */
	@PostMapping("/save")
	public void save(@RequestBody Cliente cliente) {
		service.save(cliente);
	}
	
	/**
	 * 
	 * @param cliente
	 */
	@DeleteMapping("/delete")
	public void delete(@RequestBody Cliente cliente) {
		service.delete(cliente);
	}
	
	/**
	 * 
	 * @param cliente
	 */
	@DeleteMapping("/delete/id/{id}")
	public void delete(@PathVariable Long id) {
		Cliente cliente = findById(id);
		service.delete(cliente );
	}
}
