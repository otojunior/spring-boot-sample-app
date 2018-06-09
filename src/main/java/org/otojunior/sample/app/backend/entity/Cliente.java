/**
 * 
 */
package org.otojunior.sample.app.backend.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
@Entity
public class Cliente extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@NotNull
	@CPF
	@Column(nullable=false, unique=false, length=11)
	private String cpf;
	
	@NotNull
	@Size(min=1, max=50)
	@Column(nullable=false, length=50)
	private String nome;
	
	@NotNull
	@Column(nullable=false)
	private LocalDate dataNascimento;
	
	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(nullable=true)
	private byte[] foto;
	
	@Valid
	@Embedded
	private InformacaoContato informacaoContato;
	
	@Valid
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=true, mappedBy="cliente")
	private List<Endereco> enderecos = new ArrayList<>();

	/**
	 * 
	 * @param endereco
	 */
	public Cliente addEndereco(Endereco endereco) {
		this.enderecos.add(endereco);
		endereco.setCliente(this);
		return this;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @return the dataNascimento
	 */
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * @return the endereco
	 */
	public List<Endereco> getEnderecos() {
		return Collections.unmodifiableList(enderecos);
	}

	/**
	 * @return the foto
	 */
	public byte[] getFoto() {
		return foto;
	}

	/**
	 * @return the informacaoContato
	 */
	public InformacaoContato getInformacaoContato() {
		return informacaoContato;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * 
	 * @param endereco
	 */
	public Cliente removeEndereco(Endereco endereco) {
		this.enderecos.remove(endereco);
		endereco.setCliente(null);
		return this;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @param dataNascimento the dataNascimento to set
	 */
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/**
	 * @param foto the foto to set
	 */
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	/**
	 * @param informacaoContato the informacaoContato to set
	 */
	public void setInformacaoContato(InformacaoContato informacaoContato) {
		this.informacaoContato = informacaoContato;
	}
	
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
}
