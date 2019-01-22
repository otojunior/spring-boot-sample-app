/*
 * Copyright 2019 the original author or authors.
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
