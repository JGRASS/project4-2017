package sudoku.generator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sudoku.Polje;

public class GeneratorProveraTest {

	private GeneratorProvera gen;
	
	@Before
	public void setUp() throws Exception {
		gen = new GeneratorProvera();
	}

	@After
	public void tearDown() throws Exception {
		gen = null;
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testSetMatrica() {
		gen.setMatrica(new Polje[9][9]);
		
		assertEquals(new Polje[9][9], gen.getMatrica());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetMatricaNull() {
		gen.setMatrica(null);
	}

}
