/**
 * 
 */
package org.otojunior.sample.app.backend.service;

import org.otojunior.sample.app.backend.entity.Arquivo;
import org.otojunior.sample.app.backend.repository.ArquivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author otojunior
 *
 */
@Service
public class ArquivoService {
	@Autowired
	private ArquivoRepository repository;
	
	/**
	 *
	 * @param item
	 * @return
	 */
	@Transactional
	public Arquivo save(Arquivo arquivo) {
		return repository.saveAndFlush(arquivo);
	}
}
