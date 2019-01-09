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
 * <p>ActuatorHealthControllerAdvice class.</p>
 *
 * @author 01456231650
 * @version $Id: $Id
 */
@ControllerAdvice
public class ActuatorHealthControllerAdvice {
	@Autowired
	private HealthEndpoint healthEndpoint;
	
	/**
	 * <p>infoStatus.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	@ModelAttribute("infoStatus")
	public String infoStatus() {
		return healthEndpoint.
			health().
			getStatus().
			getCode();
	}
	
	/**
	 * <p>infoBancoDados.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	@ModelAttribute("infoBancoDados")
	public String infoBancoDados() {
		Map<String, Object> details = healthEndpoint.
			health().
			getDetails();
		return String.valueOf(details.get("db"));
	}
}
