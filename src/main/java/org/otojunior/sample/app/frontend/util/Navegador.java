/**
 * 
 */
package org.otojunior.sample.app.frontend.util;

import java.util.ArrayList;
import java.util.List;

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
		
		/*
		 * Ajuste de total de paginas, pois o indice da pagina começa de 0.
		 */
		totalPaginas--;
		
		boolean anterior = false;
		boolean proximo = true;
		
		if (pagina > totalPaginas) {
			pagina = totalPaginas;
		}
		
		int min = ((pagina/totalPaginasJanela) * totalPaginasJanela);
		if (min > 0) {
			anterior = true;
		}
		
		int max = (min + (totalPaginasJanela-1));
		if (max >= totalPaginas) {
			max = totalPaginas;
			proximo = false;
		}
		
		return new Navegador(min, max, anterior, proximo,
			pagina, totalPaginas, totalPaginasJanela);
	}
	
	private int min;
	private int max;
	private int pagina;
	private int totalPaginas;
	private int totalPaginasJanela;
	private boolean anterior;
	private boolean proximo;
	
	/**
	 * 
	 */
	private Navegador(int min, int max, boolean anterior, boolean proximo,
			int pagina, int totalPaginas, int totalPaginasJanela) {
		this.min = min;
		this.max = max;
		this.pagina = pagina;
		this.totalPaginas = totalPaginas;
		this.totalPaginasJanela = totalPaginasJanela;
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
