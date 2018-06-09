/**
 * 
 */
package org.otojunior.sample.app.backend.service;

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
	 * @param cpf
	 * @return
	 */
	public Cliente findByCpf(String cpf) {
		return repository.findByCpf(cpf);
	}
}
