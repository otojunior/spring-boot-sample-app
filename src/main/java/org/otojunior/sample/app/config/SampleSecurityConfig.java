/**
 * 
 */
package org.otojunior.sample.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 * Referências: 
 * http://www.baeldung.com/spring-security-expressions
 * https://spring.io/guides/topicals/spring-security-architecture/
 */
@Configuration
@EnableWebSecurity
public class SampleSecurityConfig extends WebSecurityConfigurerAdapter {
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
	
	/**
	 * 
	 */
	@Bean
    protected UserDetailsService userDetailsService() {
        // ensure the passwords are encoded properly
        UserBuilder users = User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(users.username("user").password("passwd").roles("USER").build());
        manager.createUser(users.username("admin").password("passwd").roles("USER","ADMIN").build());
        return manager;
    }
}
