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
