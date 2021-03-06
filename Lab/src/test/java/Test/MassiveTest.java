package Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class MassiveTest {
	
	private int az;

	@BeforeClass
	public static void prisvoenieTest() {
		int az = (int) (Math.random()*70 + 20);
	}

	@Test
	public void massTest() {
		int[] a = new int[9];
		for (int i = 0; i < 9; i++) {
			prisvoenieTest();
			a[i] = az;
		}
		assertTrue(a.length == 9);
		assertFalse(a==null);
	}
}
