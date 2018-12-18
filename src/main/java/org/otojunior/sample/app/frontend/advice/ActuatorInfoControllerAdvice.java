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
	@ModelAttribute("info")
	public Map<String, Object> readInfo() {
		return infoEndpoint.info();
	}
}
