/**
 * 
 */
package org.otojunior.sample.app.entity;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
public class EnderecoTest {
	/**
	 * 
	 * @return
	 */
	public static Endereco of() {
		return of(false, "Rua Teste de Unidade", "12345A", "AP 123 BL 99", "Bairro Teste",
			"Belo Horizonte", Uf.MG, "30000000");
	}
	
	/**
	 * 
	 * @param logradouro
	 * @param numero
	 * @param complemento
	 * @param bairro
	 * @param cidade
	 * @param uf
	 * @param cep
	 * @return
	 */
	public static Endereco of(boolean ativo, String logradouro, String numero, String complemento, String bairro, 
			String cidade, Uf uf, String cep) {
		Endereco endereco = new Endereco();
		endereco.setAtivo(ativo);
		endereco.setBairro(bairro);
		endereco.setCep(cep);
		endereco.setCidade(cidade);
		endereco.setComplemento(complemento);
		endereco.setLogradouro(logradouro);
		endereco.setNumero(numero);
		endereco.setUf(uf);
		return endereco;
	}
}
