/**
 * 
 */
package org.otojunior.sample.app.backend.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 *
 */
public class AbstractEntityTest {
	@SuppressWarnings("serial")
	private static final class TestEntity extends AbstractEntity { }
	
	/**
	 * Test method for {@link org.otojunior.sample.app.backend.entity.AbstractEntity#equals(java.lang.Object)}.
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	@Test
	public void testEquals() throws Exception {
		AbstractEntity entity1 = new TestEntity();
		AbstractEntity entity2 = new TestEntity();
		entity1.setId(Long.valueOf(1L));
		entity2.setId(Long.valueOf(1L));
		assertTrue(entity1.equals(entity2));
	}
	
	/**
	 * Test method for {@link org.otojunior.sample.app.backend.entity.AbstractEntity#equals(java.lang.Object)}.
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	@Test
	public void testEquals2() throws Exception {
		AbstractEntity entity1 = new TestEntity();
		AbstractEntity entity2 = new TestEntity();
		entity2.setId(Long.valueOf(1L));
		assertFalse(entity1.equals(entity2));
	}
	
	/**
	 * Test method for {@link org.otojunior.sample.app.backend.entity.AbstractEntity#equals(java.lang.Object)}.
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	@Test
	public void testEquals3() throws Exception {
		AbstractEntity entity1 = new TestEntity();
		AbstractEntity entity2 = new TestEntity();
		assertTrue(entity1.equals(entity2));
	}
	
	/**
	 * Test method for {@link org.otojunior.sample.app.backend.entity.AbstractEntity#equals(java.lang.Object)}.
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	@Test
	public void testEquals4() throws Exception {
		AbstractEntity entity1 = new TestEntity();
		AbstractEntity entity2 = new TestEntity();
		entity1.setId(Long.valueOf(1L));
		entity2.setId(Long.valueOf(2L));
		assertFalse(entity1.equals(entity2));
	}
	
	/**
	 * Test method for {@link org.otojunior.sample.app.backend.entity.AbstractEntity#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsMesmoObjeto() {
		AbstractEntity entity = new TestEntity();
		assertTrue(entity.equals(entity));
	}
	
	/**
	 * Test method for {@link org.otojunior.sample.app.backend.entity.AbstractEntity#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsNull() {
		assertFalse(new TestEntity().equals(null));
	}
	
	/**
	 * Test method for {@link org.otojunior.sample.app.backend.entity.AbstractEntity#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsOutraClasse() {
		assertFalse(new TestEntity().equals("string"));
	}
	
	/**
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * 
	 */
	@Test
	public void testGetValues() throws Exception {
		AbstractEntity entity = new TestEntity();
		entity.setId(Long.valueOf(1L));
		entity.setVersao(Long.valueOf(2L));
		assertEquals(1L, entity.getId().longValue());
		assertEquals(2L, entity.getVersao().longValue());
	}
	
	/**
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * 
	 */
	@Test
	public void testHashCode() throws Exception {
		AbstractEntity entity = new TestEntity();
		entity.setId(Long.valueOf(1L));
		assertEquals(32, entity.hashCode());
	}
	
	/**
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * 
	 */
	@Test
	public void testHashCodeNull() throws Exception {
		assertEquals(31, new TestEntity().hashCode());
	}
	
	/**
	 * @throws Exception 
	 * 
	 */
	@Test
	public void testString() throws Exception {
		AbstractEntity entity = new TestEntity();
		entity.setId(Long.valueOf(1L));
		entity.setVersao(Long.valueOf(2L));
		assertEquals("AbstractEntityTest.TestEntity[id=1,versao=2]", entity.toString());
	}
}
