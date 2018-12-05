/**
 * 
 */
package org.otojunior.sample.app.backend.exception;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author 01456231650
 *
 */
public class HttpNotFoundExceptionTest {

	/**
	 * Test method for {@link org.otojunior.sample.app.backend.exception.HttpNotFoundException#HttpNotFoundException(java.lang.String)}.
	 */
	@Test
	public void testHttpNotFoundException() {
		HttpNotFoundException exception = new HttpNotFoundException("teste");
		assertEquals("teste", exception.getMessage());
	}
}
