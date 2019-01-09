/**
 * 
 */
package org.otojunior.sample.app.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>SampleMvcConfig class.</p>
 *
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 * @version $Id: $Id
 */
@Configuration
public class SampleMvcConfig implements WebMvcConfigurer {
	/** {@inheritDoc} */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
	}
}
