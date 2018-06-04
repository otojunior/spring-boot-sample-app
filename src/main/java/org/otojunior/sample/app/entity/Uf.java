/**
 * 
 */
package org.otojunior.sample.app.entity;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Enumeração que representa Unidade Federativa do Brasil. 
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 */
public enum Uf implements Serializable {
	AC(12, "AC", "Acre"),
	AL(27, "AL", "Alagoas"),
	AM(13, "AM", "Amazonas"),
	AP(16, "AP", "Amapá"),
	BA(29, "BA", "Bahia"),
	CE(23, "CE", "Ceará"),
	DF(53, "DF", "Distrito Federal"),
	ES(32, "ES", "Espírito Santo"),
	GO(52, "GO", "Goiás"),
	MA(21, "MA", "Maranhão"),
	MG(31, "MG", "Minas Gerais"),
	MS(50, "MS", "Mato Grosso do Sul"),
	MT(51, "MT", "Mato Grosso"),
	PA(15, "PA", "Pará"),
	PB(25, "PB", "Paraíba"),
	PE(26, "PE", "Pernambuco"),
	PI(22, "PI", "Piauí"),
	PR(41, "PR", "Paraná"),
	RJ(33, "RJ", "Rio de Janeiro"),
	RN(24, "RN", "Rio Grande do Norte"),
	RO(11, "RO", "Rondônia"),
	RR(14, "RR", "Roraima"),
	RS(43, "RS", "Rio Grande do Sul"),
	SE(28, "SE", "Sergipe"),
	TO(17, "TO", "Tocantins"),
	SC(42, "SC", "Santa Catarina"),
	SP(35, "SP", "São Paulo");
	
	private Integer codigoIbge;
	private String sigla;
	private String nome;
	
	/**
	 * Construtor padrão.
	 * @param codigoIbge Código IBGE.
	 * @param sigla Sigla da Unidade Federativa.
	 * @param nome Nome da Unidade Federativa.
	 */
	private Uf(Integer codigoIbge, String sigla, String nome) {
		this.codigoIbge = codigoIbge;
		this.sigla = sigla;
		this.nome = nome;
	}

	/**
	 * @return the codigoIbge
	 */
	public Integer getCodigoIbge() {
		return codigoIbge;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return the sigla
	 */
	public String getSigla() {
		return sigla;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
