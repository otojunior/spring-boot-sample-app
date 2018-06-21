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
 * Refeência: http://www.baeldung.com/spring-security-expressions
 */
@Configuration
@EnableWebSecurity
public class SampleSecurityConfig extends WebSecurityConfigurerAdapter {
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Configurações de segurança das aplicações utilitárias.
		http.authorizeRequests().
			antMatchers("/h2-console/**").
			permitAll();
		
		// Configurações comuns de segurança de URL.
		http.
			authorizeRequests().antMatchers("/").permitAll().and().
			authorizeRequests().antMatchers("/api/cliente/**").authenticated().and().
			authorizeRequests().antMatchers("/api/endereco/**").hasRole("TESTE");
		
		// Específico para Form Login
		http.
		 formLogin().permitAll().and().
		 logout().permitAll();
		
		// Específico para acesso ao H2-Console sem necessitar de autenticação.
		http.
			csrf().disable().
			headers().frameOptions().disable();
	}
}
