/**
 * 
 */
package org.otojunior.sample.app.frontend.advice;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.InfoEndpoint;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * @author 01456231650
 *
 */
@ControllerAdvice
public class ActuatorInfoControllerAdvice {
	@Autowired
	private InfoEndpoint infoEndpoint;
	
	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@ModelAttribute("infoVersao")
	public String infoVersao() {
		Map<String, Object> info = infoEndpoint.info();
		Map<String, String> build = (Map<String, String>) info.get("build");
		return build.get("version");
	}
}
