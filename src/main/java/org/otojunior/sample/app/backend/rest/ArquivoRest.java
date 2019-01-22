/*
 * Copyright 2019 the original author or authors.
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
package org.otojunior.sample.app.backend.rest;

import java.io.IOException;

import org.otojunior.sample.app.backend.entity.Arquivo;
import org.otojunior.sample.app.backend.service.ArquivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>ArquivoRest class.</p>
 *
 * @author otojunior
 * @version $Id: $Id
 */
@Slf4j
@RestController
@RequestMapping("/${sample.app.rest.rootpath}/arquivo")
public class ArquivoRest {
	@Autowired
	private ArquivoService service;
	
	/**
	 * <p>save.</p>
	 *
	 * @param codigo a {@link java.lang.Long} object.
	 * @param file a {@link org.springframework.web.multipart.MultipartFile} object.
	 * @return a {@link org.springframework.http.ResponseEntity} object.
	 * @throws java.io.IOException if any.
	 */
	@PostMapping("/{codigo}")
	public ResponseEntity<Arquivo> save(
			@PathVariable Long codigo,
			@RequestParam("file") MultipartFile file) throws IOException {
		
		byte[] conteudo = FileCopyUtils.copyToByteArray(file.getInputStream());

		Arquivo arquivo = new Arquivo();
		arquivo.setCodigo(codigo);
		arquivo.setNome(file.getOriginalFilename());
		arquivo.setTamanho(file.getSize());
		arquivo.setConteudo(conteudo);
		
		Arquivo salvo = service.save(arquivo);
		
		if (log.isDebugEnabled()) {
			log.debug("save: {}", salvo);
			log.debug("conteudo: {}", new String(conteudo, "UTF-8"));
		}

		return ResponseEntity.ok(salvo);
	}
}
