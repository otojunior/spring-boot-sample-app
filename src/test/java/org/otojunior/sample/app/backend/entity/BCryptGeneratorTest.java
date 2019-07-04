/**
 * 
 */
package org.otojunior.sample.app.backend.entity;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.extern.slf4j.Slf4j;


/**
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 *
 */
@Slf4j
public class BCryptGeneratorTest {
	/**
	 * 
	 */
	@Test
	public void generateBCryptPassword() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		log.info("user: {} - password: {}", "passwd123", encoder.encode("passwd123"));
		log.info("user: {} - password: {}", "passwd456", encoder.encode("passwd456"));
	}
}
