/**
 * 
 */
package org.otojunior.sample.app.frontend.util;

import java.util.stream.IntStream;

import org.springframework.data.domain.Page;

import lombok.Getter;

/**
 * <p>Navegador class.</p>
 *
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 * @version $Id: $Id
 */
@Getter
public class Navegador {
	/**
	 * <p>of.</p>
	 *
	 * @param page a {@link org.springframework.data.domain.Page} object.
	 * @param totalPaginasJanela a int.
	 * @return a {@link org.otojunior.sample.app.frontend.util.Navegador} object.
	 */
	public static Navegador of(Page<?> page, int totalPaginasJanela) {
		return of(page.getNumber(), page.getTotalPages(), totalPaginasJanela);
	}

	/**
	 * <p>of.</p>
	 *
	 * @param pagina Numero da pagina
	 * @param totalPaginas Total de paginas
	 * @param totalPaginasJanela Quantidade de registros por pagina
	 * @param totalPaginasJanela Quantidade de registros por pagina
	 * @param totalPaginasJanela Quantidade de registros por pagina
	 * @param totalPaginasJanela Quantidade de registros por pagina
	 * @param totalPaginasJanela Quantidade de registros por pagina
	 * @param totalPaginasJanela Quantidade de registros por pagina
	 * @return a {@link org.otojunior.sample.app.frontend.util.Navegador} object.
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
	 * <p>getIntervalo.</p>
	 *
	 * @return an array of {@link int} objects.
	 */
	public int[] getIntervalo() {
		return IntStream.rangeClosed(min, max).toArray();
	}
	
	/**
	 * <p>getJanelaAnterior.</p>
	 *
	 * @return a {@link java.lang.Integer} object.
	 */
	public Integer getJanelaAnterior() {
		int anterior = (pagina - totalPaginasJanela);
		return (anterior < 0) ? 0 : anterior;
	}
	
	/**
	 * <p>getProximaJanela.</p>
	 *
	 * @return a {@link java.lang.Integer} object.
	 */
	public Integer getProximaJanela() {
		int proxima = (pagina + totalPaginasJanela);
		int ultimaPagina = (totalPaginas - 1);
		return (proxima > ultimaPagina) ? ultimaPagina : proxima; 
	}

	/**
	 * <p>getPrimeiraJanela.</p>
	 *
	 * @return a {@link java.lang.Integer} object.
	 */
	public Integer getPrimeiraJanela() {
		return 0;
	}
	
	
	/**
	 * <p>getUltimaJanela.</p>
	 *
	 * @return a {@link java.lang.Integer} object.
	 */
	public Integer getUltimaJanela() {
		return (totalPaginas - 1);
	}
	
	/**
	 * <p>isAnterior.</p>
	 *
	 * @return a boolean.
	 */
	public boolean isAnterior() {
		return (min > 0);
	}
	
	/**
	 * <p>isProximo.</p>
	 *
	 * @return a boolean.
	 */
	public boolean isProximo() {
		int ultimaPagina = (totalPaginas - 1);
		return (max < ultimaPagina);
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString() {
		return isAnterior() + " [" + min + ".." + max + "] " + isProximo();
	}
}
