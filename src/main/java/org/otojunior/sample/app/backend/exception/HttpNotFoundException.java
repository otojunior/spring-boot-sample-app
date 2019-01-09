/**
 * 
 */
package org.otojunior.sample.app.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * <p>HttpNotFoundException class.</p>
 *
 * @author 01456231650
 * @version $Id: $Id
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class HttpNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	/**
	 * <p>Constructor for HttpNotFoundException.</p>
	 *
	 * @param mensagem a {@link java.lang.String} object.
	 */
	public HttpNotFoundException(String mensagem) {
		super(mensagem);
	}
}
