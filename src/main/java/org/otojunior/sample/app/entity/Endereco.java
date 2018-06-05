/**
 * 
 */
package org.otojunior.sample.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Endereço.
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
@Entity
public class Endereco extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@NotNull
	@Size(min=1, max=80)
	@Column(nullable=false, length=80)
	private String logradouro;
	
	@Size(min=0, max=6)
	@Column(length=6)
	private String numero;

	@Size(min=0, max=30)
	@Column(length=30)
	private String complemento;
	
	@Size(min=0, max=50)
	@Column(length=50)
	private String bairro;
	
	@NotNull
	@Size(min=1, max=50)
	@Column(nullable=false, length=50)
	private String cidade;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Uf uf;
	
	@Size(min=0, max=8)
	@Column(length=8)
	private String cep;
	
	@Column(nullable=false)
	private boolean ativo;
	
	@ManyToOne
	private Cliente cliente;

	/**
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @return the complemento
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * @return the logradouro
	 */
	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @return the uf
	 */
	public Uf getUf() {
		return uf;
	}

	/**
	 * @return the ativo
	 */
	public boolean isAtivo() {
		return ativo;
	}

	/**
	 * @param ativo the ativo to set
	 */
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	/**
	 * @param bairro the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * @param cep the cep to set
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	/**
	 * @param complemento the complemento to set
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	/**
	 * @param logradouro the logradouro to set
	 */
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @param uf the uf to set
	 */
	public void setUf(Uf uf) {
		this.uf = uf;
	}
}
