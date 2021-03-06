package Test;

import static org.junit.Assert.*;

import org.junit.Test;

public class randomTest {

	@Test
	public void test() {
		
			int ran;
			ran = (int) (Math.random() * 70 + 20);
			assertTrue(ran > 19 || ran < 91);
		}
}
