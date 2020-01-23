package first;

import static org.junit.Assert.*;

import org.junit.Test;

import first.core.StringDividerImpl;

public class StringDivederImplTest {

	@Test
	public void testDivider() {
		StringDividerImpl sd = new StringDividerImpl();
		String s ="123456789abcdefgh";
		String[] r = sd.divide(s, 4);
		assertTrue(r[1].equals("h"));	
	}
}
