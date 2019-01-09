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
 * <p>ArquivoService class.</p>
 *
 * @author otojunior
 * @version $Id: $Id
 */
@Service
public class ArquivoService {
	@Autowired
	private ArquivoRepository repository;
	
	/**
	 * <p>save.</p>
	 *
	 * @param arquivo a {@link org.otojunior.sample.app.backend.entity.Arquivo} object.
	 * @return a {@link org.otojunior.sample.app.backend.entity.Arquivo} object.
	 */
	@Transactional
	public Arquivo save(Arquivo arquivo) {
		return repository.saveAndFlush(arquivo);
	}
}
