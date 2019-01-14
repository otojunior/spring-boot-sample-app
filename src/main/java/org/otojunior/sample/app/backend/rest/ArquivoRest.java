/**
 * 
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
