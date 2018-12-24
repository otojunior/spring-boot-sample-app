/**
 * 
 */
package org.otojunior.sample.app.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 * Referências: 
 * http://www.baeldung.com/spring-security-expressions
 * https://spring.io/guides/topicals/spring-security-architecture/
 */
@Configuration
@EnableWebSecurity
public class SampleSecurityAuthorizationConfig extends WebSecurityConfigurerAdapter {
	private final String[] PERMITED = {
		"/actuator/**",
		"/h2-console/**",
		"/css/**",
		"/imagens/**" };
	
	private final String[] FOR_USER_ROLE = {
		"/item/**" };
	
	private final String[] FOR_ADMIN_ROLE = {
		"/api/**" };
		
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().
			antMatchers(PERMITED).permitAll().
			antMatchers(FOR_USER_ROLE).access("hasRole('USER') or hasRole('ADMIN')").
			antMatchers(FOR_ADMIN_ROLE).hasRole("ADMIN").
			anyRequest().authenticated().
		and().
			formLogin().permitAll().
		and().
			csrf().disable().
			headers().frameOptions().disable();
	}
}
