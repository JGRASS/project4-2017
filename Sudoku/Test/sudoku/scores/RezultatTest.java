package sudoku.scores;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RezultatTest {
	private Rezultat rez;

	@Before
	public void setUp() throws Exception {
		rez = new Rezultat();
	}

	@After
	public void tearDown() throws Exception {
		rez = null;
	}

	@Test
	public void testSetIme() {
		rez.setIme("Pera");
		
		assertEquals("Pera", rez.getIme());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetImeNull() {
		rez.setIme(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetImePrazanString() {
		rez.setIme("");
	}

	@Test
	public void testSetSati() {
		rez.setSati(1);
		
		assertEquals(1, rez.getSati());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetSatiManjeOd0() {
		rez.setSati(-7);
	}

	@Test
	public void testSetMinuti() {
		rez.setMinuti(12);
		
		assertEquals(12, rez.getMinuti());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetMinutiManjeOd0() {
		rez.setMinuti(-9);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetMinutiVeceOd59() {
		rez.setMinuti(256);
	}

	@Test
	public void testSetSekunde() {
		rez.setSekunde(45);
		
		assertEquals(45, rez.getSekunde());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetSekundeManjeOd0() {
		rez.setSekunde(-18);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetSekundeVeceOd59() {
		rez.setSekunde(750);
	}

}
