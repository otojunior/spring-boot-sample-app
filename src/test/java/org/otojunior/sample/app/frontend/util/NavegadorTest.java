/**
 * 
 */
package org.otojunior.sample.app.frontend.util;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
public class NavegadorTest {
	/**
	 * Test method for {@link org.otojunior.sample.app.frontend.util.Navegador#toString()}.
	 */
	@Test
	public void testToString07() {
		int tot = 35;
		int quant = 7;
		assertEquals("false [0..6] true", Navegador.of(2, tot, quant).toString());
		assertEquals("true [7..13] true", Navegador.of(10, tot, quant).toString());
		assertEquals("true [21..27] true", Navegador.of(25, tot, quant).toString());
		assertEquals("true [28..34] false", Navegador.of(34, tot, quant).toString());
		assertEquals("true [28..34] false", Navegador.of(39, tot, quant).toString());
	}
	
	/**
	 * Test method for {@link org.otojunior.sample.app.frontend.util.Navegador#toString()}.
	 */
	@Test
	public void testToString10() {
		int tot = 35;
		int quant = 10;
		assertEquals("false [0..9] true", Navegador.of(2, tot, quant).toString());
		assertEquals("true [10..19] true", Navegador.of(10, tot, quant).toString());
		assertEquals("true [20..29] true", Navegador.of(25, tot, quant).toString());
		assertEquals("true [30..34] false", Navegador.of(34, tot, quant).toString());
		assertEquals("true [30..34] false", Navegador.of(39, tot, quant).toString());
	}
	
	/**
	 * 
	 */
	@Test
	public void testGetIntervalo() {
		List<Integer> intervalo = Navegador.of(25, 35, 7).getIntervalo();
		assertEquals(7, intervalo.size());
		assertEquals(21, intervalo.get(0).intValue());
		assertEquals(22, intervalo.get(1).intValue());
		assertEquals(23, intervalo.get(2).intValue());
		assertEquals(24, intervalo.get(3).intValue());
		assertEquals(25, intervalo.get(4).intValue());
		assertEquals(26, intervalo.get(5).intValue());
		assertEquals(27, intervalo.get(6).intValue());
	}
}
