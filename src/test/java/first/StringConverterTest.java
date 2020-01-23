package first;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.junit.BeforeClass;
import org.junit.Test;

import first.core.StringConverter;
import first.core.StringConverterImpl;

public class StringConverterTest {
	static String text = "";
	static StringConverter sc = null;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		sc = new StringConverterImpl();
		URL resource = sc.getClass().getResource("/textSamples/1.txt");
		InputStream in = null;
		try {
			in = resource.openStream();
			byte[] buffer = new byte[128];
			int readCount = 0;
			StringBuilder sb = new StringBuilder();
			while ((readCount = in.read(buffer)) != -1) {
				String part = new String(buffer, 0, readCount);
				sb.append(part);
			}
			text = sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testConvert() {
		String str = "Sep 21, 2017 - So you can 99999get The int value of a Decimal digit Char X by subtracting '0' . ... I you have the char '9' , it will store its ASCII code, so to get the int value, you ... In this example, we have a character ('a'), and we cast it to an integer." ;
		String r = sc.convert(str, true);
		assertTrue(r.equals("0A0a1a1a2a2a7a9a9a9a9a9a9aaaaaaabbCCccccccccDdddeeeeeeeeeeeeeeeeeeeefggggghhhhhhhhhIIIIiiiiiiiiiiiillllllmmnnnnnnnnoooooooooopprrrrrrrSSSssssssTtttttttttttttttttttuuuuuuvvvvwwwXxyyyy"));
	}

}
