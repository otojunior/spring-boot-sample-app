/**
 * 
 */
package org.otojunior.sample.app.backend.service;

import java.util.List;
import java.util.Optional;

import org.otojunior.sample.app.backend.entity.Endereco;
import org.otojunior.sample.app.backend.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author otojunior
 *
 */
@Service
@Transactional(readOnly=true)
public class EnderecoService {
	@Autowired
	private EnderecoRepository repository;
	
	/**
	 * 
	 * @return
	 */
	public List<Endereco> findAll() {
		return repository.findAll();
	}
	
	/**
	 * 
	 * @param cpf
	 * @return
	 */
	public Optional<Endereco> findByCep(String cep) {
		return repository.findByCep(cep);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Optional<Endereco> findById(Long id) {
		return repository.findById(id);
	}
}
