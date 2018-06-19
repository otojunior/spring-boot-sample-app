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
public class ClienteNaoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private String mensagemPesquisa;
	private String chavePesquisa;
	
	/**
	 * 
	 */
	public ClienteNaoEncontradoException(String mensagemPesquisa, String chavePesquisa) {
		super("Cliente não encontrado. " + mensagemPesquisa + chavePesquisa);
		this.mensagemPesquisa = mensagemPesquisa;
		this.chavePesquisa = chavePesquisa;
	}

	/**
	 * @return the mensagemPesquisa
	 */
	public String getMensagemPesquisa() {
		return mensagemPesquisa;
	}

	/**
	 * @return the chavePesquisa
	 */
	public String getChavePesquisa() {
		return chavePesquisa;
	}
}
