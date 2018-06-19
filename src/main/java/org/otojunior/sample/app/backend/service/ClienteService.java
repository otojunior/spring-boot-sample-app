/**
 * 
 */
package org.otojunior.sample.app.backend.service;

import java.util.List;
import java.util.Optional;

import org.otojunior.sample.app.backend.entity.Cliente;
import org.otojunior.sample.app.backend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author otojunior
 *
 */
@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repository;
	
	/**
	 * 
	 * @param cliente
	 */
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Cliente> findAll() {
		return repository.findAll();
	}
	
	/**
	 * 
	 * @param cpf
	 * @return
	 */
	public Optional<Cliente> findByCpf(String cpf) {
		return repository.findByCpf(cpf);
	}
	
	/**
	 * 
	 * @param cpf
	 * @return
	 */
	public Optional<Cliente> findByNome(String nome) {
		return repository.findByNome(nome);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Optional<Cliente> findById(Long id) {
		return repository.findById(id);
	}

	/**
	 * 
	 * @param cliente
	 */
	public Cliente save(Cliente cliente) {
		return repository.save(cliente);
	}
}
