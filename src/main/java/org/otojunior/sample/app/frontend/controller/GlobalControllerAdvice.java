/**
 * 
 */
package org.otojunior.sample.app.frontend.controller;

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
public class GlobalControllerAdvice {
	@Autowired
	private InfoEndpoint infoendpoint;
	
	/**
	 * 
	 * @return
	 */
	@ModelAttribute("buildinfo")
	public Object readInfo() {
		Map<String, Object> infomap = infoendpoint.info();
		Object buildinfo = infomap.get("build");
		return buildinfo;
	}
}
