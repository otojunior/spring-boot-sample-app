/**
 * 
 */
package org.otojunior.sample.app.frontend.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
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
	@ModelAttribute("health")
	public Health readInfo() {
		return healthEndpoint.health();
	}
}
