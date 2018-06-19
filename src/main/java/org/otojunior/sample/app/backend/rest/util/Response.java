/**
 * 
 */
package org.otojunior.sample.app.backend.rest.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 01456231650
 *
 */
public class Response<T> {
	private T conteudo;
	private List<String> erros = new ArrayList<>();
	
	/**
	 * Construtor padrão.
	 * @param conteudo
	 */
	public Response() {
		/*
		 * Construtor padrão.
		 */
	}
	
	/**
	 * 
	 * @param conteudo
	 */
	public Response(T conteudo) {
		this.conteudo = conteudo;
	}
	
	/**
	 * 
	 * @param conteudo
	 */
	public Response(T conteudo, String... erros) {
		this.conteudo = conteudo;
		if (erros != null) {
			for (String erro : erros) {
				this.erros.add(erro);
			}
		}
	}
	
	/**
	 * @param erros the erros to set
	 */
	public void addErro(String erro) {
		this.erros.add(erro);
	}
	
	/**
	 * @return the conteudo
	 */
	public T getConteudo() {
		return conteudo;
	}
	
	/**
	 * @return the erros
	 */
	public List<String> getErros() {
		return Collections.unmodifiableList(erros);
	}
	
	/**
	 * @param conteudo the conteudo to set
	 */
	public void setConteudo(T conteudo) {
		this.conteudo = conteudo;
	}
}
