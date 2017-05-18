package sudoku.scores;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RezultatiTest {
	
	private Rezultati r;
	
	@Before
	public void setUp() throws Exception {
		r = new Rezultati();
	}

	@After
	public void tearDown() throws Exception {
		r = null;
	}

	@Test
	public void testSetLista() {
		r.setLista(new LinkedList<Rezultat>());
		
		assertEquals(new LinkedList<Rezultat>(), r.getLista());
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetListaNull() {
		r.setLista(null);
	}
}
