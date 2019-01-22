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
 * <p>SampleSecurityConfig class.</p>
 *
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 * Referências:
 * http://www.baeldung.com/spring-security-expressions
 * https://spring.io/guides/topicals/spring-security-architecture/
 * https://www.boraji.com/spring-security-5-jdbc-based-authentication-example
 * @version $Id: $Id
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
	
	/** {@inheritDoc} */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().
			dataSource(datasource).
			passwordEncoder(new BCryptPasswordEncoder());
	}
	
	/** {@inheritDoc} */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().
			antMatchers(PERMITED).permitAll().
			antMatchers(FOR_USER_ROLE).access("hasRole('USER') or hasRole('ADMIN')").
			antMatchers(FOR_ADMIN_ROLE).hasRole("ADMIN").
			anyRequest().authenticated().
		and().
			formLogin().
				loginPage("/login").permitAll().
		and().
			logout().permitAll().
		and().
			csrf().disable().
			headers().frameOptions().disable();
	}
}
