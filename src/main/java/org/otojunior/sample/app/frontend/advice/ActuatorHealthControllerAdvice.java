/*
 * Copyright 2019 Oto Soares Coelho Junior.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.otojunior.sample.app.frontend.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.actuate.health.SystemHealth;
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
		if (healthEndpoint.health() instanceof SystemHealth) {
			SystemHealth systemHealth = (SystemHealth)healthEndpoint.health();
			Health health = (Health) systemHealth
				.getComponents()
				.get("db");
			return (String) health
				.getDetails()
				.get("database");
		}
		return "UNKNOWN";
	}
}
