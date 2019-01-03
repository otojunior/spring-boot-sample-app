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
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 * Referências: 
 * http://www.baeldung.com/spring-security-expressions
 * https://spring.io/guides/topicals/spring-security-architecture/
 * https://www.boraji.com/spring-security-5-jdbc-based-authentication-example
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
		"/imagens/**",
		"/webjars/**" };
	
	private final String[] FOR_USER_ROLE = {
		"/item/**" };
	
	private final String[] FOR_ADMIN_ROLE = {
		"/api/**" };
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(datasource).
			usersByUsernameQuery(JdbcDaoImpl.DEF_USERS_BY_USERNAME_QUERY).
			authoritiesByUsernameQuery(JdbcDaoImpl.DEF_AUTHORITIES_BY_USERNAME_QUERY).
			passwordEncoder(new BCryptPasswordEncoder());
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
			formLogin().
				loginPage("/login").
				failureUrl("/login-error").
				permitAll().
		and().
			logout().permitAll().
		and().
			csrf().disable().
			headers().frameOptions().disable();
	}
}
