/**
 * 
 */
package org.otojunior.sample.app.config.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 * Referências: 
 * http://www.baeldung.com/spring-security-expressions
 * https://spring.io/guides/topicals/spring-security-architecture/
 */
@Configuration
@EnableWebSecurity
public class SampleSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource datasource;
	
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
	 * 
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(datasource)
			.usersByUsernameQuery("select username, password, enabled from users where username=?")
			.authoritiesByUsernameQuery("select username, authority from authorities where username=?")
			.passwordEncoder(new BCryptPasswordEncoder());
	}

	
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
