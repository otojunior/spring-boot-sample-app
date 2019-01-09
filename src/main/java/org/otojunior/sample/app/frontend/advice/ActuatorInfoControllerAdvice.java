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
 * <p>ActuatorInfoControllerAdvice class.</p>
 *
 * @author 01456231650
 * @version $Id: $Id
 */
@ControllerAdvice
public class ActuatorInfoControllerAdvice {
	@Autowired
	private InfoEndpoint infoEndpoint;
	
	/**
	 * <p>infoVersao.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	@SuppressWarnings("unchecked")
	@ModelAttribute("infoVersao")
	public String infoVersao() {
		Map<String, Object> info = infoEndpoint.info();
		Map<String, String> build = (Map<String, String>) info.get("build");
		return build.get("version");
	}
}
