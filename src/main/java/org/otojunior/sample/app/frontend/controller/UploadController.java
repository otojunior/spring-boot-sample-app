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
 * @author 01456231650
 *
 */
@Slf4j
@Controller
public class UploadController {
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/upload")
	public String show(Model model) {
		return "upload_edit";
	}
	
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
