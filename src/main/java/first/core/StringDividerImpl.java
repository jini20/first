package first.core;

public class StringDividerImpl implements StringDivider {

	public String[] divide(String text, int divisor) {
		String [] r = new String [2];
		if(divisor >= text.length()) {
			r[0] = text;
			r[1] = "";
		} else {
			int remainder = text.length()%divisor;
			int splitAt = text.length() - remainder;
			r[0] = text.substring(0, splitAt);
			r[1] = text.substring(splitAt);
		}
		return r;
	}
}
