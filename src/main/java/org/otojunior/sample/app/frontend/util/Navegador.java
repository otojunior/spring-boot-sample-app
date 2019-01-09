/**
 * 
 */
package org.otojunior.sample.app.frontend.util;

import java.util.stream.IntStream;

import lombok.Getter;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
@Getter
public class Navegador {
	/**
	 * 
	 * @param pagina Numero da pagina
	 * @param totalPaginas Total de paginas
	 * @param totalPaginasJanela Quantidade de registros por pagina
	 * @return
	 */
	public static Navegador of(int pagina,
			int totalPaginas,
			int totalPaginasJanela) {
		
		int ultimaPagina = totalPaginas - 1;
		
		if (pagina > ultimaPagina) {
			pagina = ultimaPagina;
		}
		
		int min = ((pagina/totalPaginasJanela) * totalPaginasJanela);
		
		int max = (min + (totalPaginasJanela-1));
		if (max >= ultimaPagina) {
			max = ultimaPagina;
		}
		
		return new Navegador(min, max, pagina, totalPaginas, totalPaginasJanela);
	}
	
	private int min;
	private int max;
	private int pagina;
	private int totalPaginas;
	private int totalPaginasJanela;
	
	/**
	 * 
	 */
	private Navegador(int min, int max,	int pagina, int totalPaginas, int totalPaginasJanela) {
		this.min = min;
		this.max = max;
		this.pagina = pagina;
		this.totalPaginas = totalPaginas;
		this.totalPaginasJanela = totalPaginasJanela;
	}
	
	/**
	 * 
	 * @return
	 */
	public int[] getIntervalo() {
		return IntStream.rangeClosed(min, max).toArray();
	}
	
	/**
	 * 
	 * @return
	 */
	public Integer getJanelaAnterior() {
		int anterior = (pagina - totalPaginasJanela);
		return (anterior < 0) ? 0 : anterior;
	}
	
	/**
	 * 
	 * @return
	 */
	public Integer getProximaJanela() {
		int proxima = (pagina + totalPaginasJanela);
		int ultimaPagina = (totalPaginas - 1);
		return (proxima > ultimaPagina) ? ultimaPagina : proxima; 
	}

	/**
	 * 
	 * @return
	 */
	public Integer getPrimeiraJanela() {
		return 0;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public Integer getUltimaJanela() {
		return (totalPaginas - 1);
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isAnterior() {
		return (min > 0);
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isProximo() {
		int ultimaPagina = (totalPaginas - 1);
		return (max < ultimaPagina);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return isAnterior() + " [" + min + ".." + max + "] " + isProximo();
	}
}
