/**
 * 
 */
package org.otojunior.sample.app.frontend.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import lombok.Getter;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
@Getter
public class Navigation {
	/**
	 * 
	 * @param pagina Numero da pagina
	 * @param totalPaginas Total de paginas
	 * @param registrosPorPagina Quantidade de registros por pagina
	 * @return
	 */
	public static Navigation of(int pagina,
			int totalPaginas,
			int registrosPorPagina) {
		boolean anterior = false;
		boolean proximo = true;
		
		if (pagina > totalPaginas) {
			pagina = totalPaginas;
		}
		
		int min = ((pagina/registrosPorPagina) * registrosPorPagina);
		if (min > 0) {
			anterior = true;
		}
		
		int max = (min + (registrosPorPagina-1));
		if (max >= totalPaginas) {
			max = totalPaginas;
			proximo = false;
		}
		
		return new Navigation(min, max, anterior, proximo);
	}
	
	private int min;
	private int max;
	private boolean anterior;
	private boolean proximo;
	
	/**
	 * 
	 */
	private Navigation(int min, int max, boolean anterior, boolean proximo) {
		this.min = min;
		this.max = max;
		this.anterior = anterior;
		this.proximo = proximo;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Integer> getIntervalo() {
		List<Integer> intervalo = new ArrayList<>();
		for (int i = min; i <= max ; i++) {
			intervalo.add(i);
		}
		return intervalo;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return anterior + " [" + min + ".." + max + "] " + proximo;
	}
}
