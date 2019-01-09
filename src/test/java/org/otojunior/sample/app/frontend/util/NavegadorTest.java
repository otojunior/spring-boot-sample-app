/**
 * 
 */
package org.otojunior.sample.app.frontend.util;

import static org.junit.Assert.assertEquals;

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
		int[] intervalo = Navegador.of(25, 35, 7).getIntervalo();
		assertEquals(7, intervalo.length);
		assertEquals(21, intervalo[0]);
		assertEquals(22, intervalo[1]);
		assertEquals(23, intervalo[2]);
		assertEquals(24, intervalo[3]);
		assertEquals(25, intervalo[4]);
		assertEquals(26, intervalo[5]);
		assertEquals(27, intervalo[6]);
	}
}
