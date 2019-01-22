/*
 * Copyright 2019 Oto Soares Coelho Junior.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
