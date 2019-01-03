/**
 * 
 */
package org.otojunior.sample.app.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 01456231650
 *
 */
@Controller
public class IndexController {
	/**
	 * 
	 * @return
	 */
	@GetMapping("/")
	public String index() {
		return "index";
	}
}
