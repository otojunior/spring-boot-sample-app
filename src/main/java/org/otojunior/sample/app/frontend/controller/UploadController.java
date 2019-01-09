/**
 * 
 */
package org.otojunior.sample.app.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>UploadController class.</p>
 *
 * @author 01456231650
 * @version $Id: $Id
 */
@Slf4j
@Controller
public class UploadController {
	/**
	 * <p>show.</p>
	 *
	 * @param model a {@link org.springframework.ui.Model} object.
	 * @return a {@link java.lang.String} object.
	 */
	@GetMapping("/upload")
	public String show(Model model) {
		return "upload_edit";
	}
	
	/**
	 * <p>upload.</p>
	 *
	 * @param file a {@link org.springframework.web.multipart.MultipartFile} object.
	 * @return a {@link java.lang.String} object.
	 */
	@PostMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file) {
		// chamar o serviço de upload
		
		if (log.isDebugEnabled()) {
			log.debug("FILE UPLOAD");
			log.debug("Nome: {}", file.getOriginalFilename());
			log.debug("Tamanho: {}", file.getSize());
		}
		
		return "redirect:/";
	}
}
