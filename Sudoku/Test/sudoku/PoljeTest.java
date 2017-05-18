package sudoku;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PoljeTest {

	private Polje p;
	
	@Before
	public void setUp() throws Exception {
		p = new Polje();
	}

	@After
	public void tearDown() throws Exception {
		p = null;
	}

	@Test
	public void testSetGenerisanaVrednost() {
		p.setGenerisanaVrednost(5);
		
		assertEquals(5, p.getGenerisanaVrednost());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetGenerisanaVrednostManjeOd0() {
		p.setGenerisanaVrednost(-6);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetGenerisanaVrednostVeceOd9() {
		p.setGenerisanaVrednost(15);
	}

	@Test
	public void testSetUnesenaVrednost() {
		p.setUnesenaVrednost(5);
		
		assertEquals(5, p.getUnesenaVrednost());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetUnesenaVrednostManjeOd0() {
		p.setUnesenaVrednost(-7);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetUnesenaVrednostVeceOd9() {
		p.setUnesenaVrednost(63);
	}

	@Test
	public void testSetZakljucano() {
		p.setZakljucano(true);
		
		assertEquals(true, p.isZakljucano());
	}

}
