/**
 * 
 */
package org.otojunior.sample.app.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>IndexController class.</p>
 *
 * @author 01456231650
 * @version $Id: $Id
 */
@Controller
public class IndexController {
	/**
	 * <p>index.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	@GetMapping("/")
	public String index() {
		return "index";
	}
}
