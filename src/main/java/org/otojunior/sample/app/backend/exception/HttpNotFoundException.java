/**
 * 
 */
package org.otojunior.sample.app.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author 01456231650
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class HttpNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * @param mensagem
	 * @param throwable
	 */
	public HttpNotFoundException(String mensagem) {
		super(mensagem);
	}
}
