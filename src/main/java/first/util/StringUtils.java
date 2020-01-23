package first.util;

public final class StringUtils {
	
	private StringUtils() {}
	
	public static String removeTags(String text){		
		return text.replaceAll("\\<.*?>","") ;
	}
	
	public static int toAlphabetCode(char c) {	
		if (c <= 'Z')
			return (int) c - (int) 'A';
		else
			return (int) c - (int) 'a';
	}
}
