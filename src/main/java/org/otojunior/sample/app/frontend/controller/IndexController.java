/**
 * 
 */
package org.otojunior.sample.app.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("error", true);
		return "login";
	}
}
