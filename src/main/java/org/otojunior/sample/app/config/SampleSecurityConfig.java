/**
 * 
 */
package org.otojunior.sample.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
@Configuration
@EnableWebSecurity
public class SampleSecurityConfig extends WebSecurityConfigurerAdapter {
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Configurações comuns de segurança de URL.
		http.
			authorizeRequests().
				antMatchers("/").
				permitAll().and().
			authorizeRequests().
				antMatchers("/h2-console/**").
				permitAll().and().
			authorizeRequests().
				antMatchers("/api/cliente/**").
				permitAll().anyRequest().authenticated().and().
			authorizeRequests().
				antMatchers("/api/endereco/**").
				hasRole("ADMIN").anyRequest().authenticated();
		
		// Específico para Form Login
		http.
		 formLogin().loginPage("/login").permitAll().and().
		 logout().permitAll();
		
		// Específico para acesso ao H2-Console sem necessitar de autenticação.
		http.
			csrf().disable().
			headers().frameOptions().disable();
	}
}
