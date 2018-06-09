/**
 * 
 */
package org.otojunior.sample.app.entity;

import org.otojunior.sample.app.backend.entity.InformacaoContato;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
public class InformacaoContatoTest {
	/**
	 * 
	 * @param email
	 * @param telefone
	 * @param celular
	 */
	public static InformacaoContato of() {
		return of("joaquim@teste.com", "3122223333", "31988887777");
	}
	
	/**
	 * 
	 * @param email
	 * @param telefone
	 * @param celular
	 */
	public static InformacaoContato of(String email, String telefone, String celular) {
		InformacaoContato informacaoContato = new InformacaoContato();
		informacaoContato.setEmail(email);
		informacaoContato.setTelefone(telefone);
		informacaoContato.setCelular(celular);
		return informacaoContato;
	}
}
