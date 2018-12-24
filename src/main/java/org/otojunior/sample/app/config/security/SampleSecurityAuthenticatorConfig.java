/**
 * 
 */
package org.otojunior.sample.app.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
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
public class SampleSecurityAuthenticatorConfig {
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
