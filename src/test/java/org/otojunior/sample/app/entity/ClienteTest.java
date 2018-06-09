/**
 * 
 */
package org.otojunior.sample.app.entity;

import java.time.LocalDate;
import java.time.Month;

import org.otojunior.sample.app.backend.entity.Cliente;
import org.otojunior.sample.app.backend.entity.Endereco;
import org.otojunior.sample.app.backend.entity.InformacaoContato;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
public class ClienteTest {
	/**
	 * 
	 * @param cpf
	 * @param nome
	 * @param dataNascimento 
	 * @param endereco 
	 * @return
	 */
	public static Cliente of() {
		return of("00000000191", "Joaquim da Silva", LocalDate.of(1975, Month.JANUARY, 15), 
			InformacaoContatoTest.of(), EnderecoTest.of());
	}
	
	/**
	 * 
	 * @param cpf
	 * @param nome
	 * @param dataNascimento 
	 * @param endereco 
	 * @param informacaoContato 
	 * @return
	 */
	public static Cliente of(String cpf, String nome, LocalDate dataNascimento, InformacaoContato informacaoContato, 
			Endereco endereco) {
		Cliente cliente = new Cliente();
		cliente.setCpf(cpf);
		cliente.setDataNascimento(dataNascimento);
		cliente.setNome(nome);
		cliente.setInformacaoContato(informacaoContato);
		cliente.addEndereco(endereco);
		return cliente;
	}
}
