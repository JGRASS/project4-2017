package sudoku;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IgraTest {

	private Igra i;
	
	@Before
	public void setUp() throws Exception {
		i = new Igra();
	}

	@After
	public void tearDown() throws Exception {
		i = null;
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testSetMatrica() {
		i.setMatrica(new Polje[9][9]);
		
		assertEquals(new Polje[9][9], i.getMatrica());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetMatricaNull() {
		i.setMatrica(null);
	}

	@Test
	public void testSetSati() {
		i.setSati(1);
		
		assertEquals(1, i.getSati());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetSatiManjeOd0() {
		i.setSati(-7);
	}

	@Test
	public void testSetMinuti() {
		i.setMinuti(12);
		
		assertEquals(12, i.getMinuti());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetMinutiManjeOd0() {
		i.setMinuti(-9);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetMinutiVeceOd59() {
		i.setMinuti(256);
	}

	@Test
	public void testSetSekunde() {
		i.setSekunde(45);
		
		assertEquals(45, i.getSekunde());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetSekundeManjeOd0() {
		i.setSekunde(-18);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetSekundeVeceOd59() {
		i.setSekunde(750);
	}

}
