/**
 * 
 */
package org.otojunior.sample.app.frontend.advice;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * @author 01456231650
 *
 */
@ControllerAdvice
public class ActuatorHealthControllerAdvice {
	@Autowired
	private HealthEndpoint healthEndpoint;
	
	/**
	 * 
	 * @return
	 */
	@ModelAttribute("infoStatus")
	public String infoStatus() {
		return healthEndpoint.
			health().
			getStatus().
			getCode();
	}
	
	/**
	 * 
	 * @return
	 */
	@ModelAttribute("infoBancoDados")
	public String infoBancoDados() {
		Map<String, Object> details = healthEndpoint.
			health().
			getDetails();
		return String.valueOf(details.get("db"));
	}
}
