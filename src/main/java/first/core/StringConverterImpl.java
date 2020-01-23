package first.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import first.util.StringUtils;

public class StringConverterImpl implements StringConverter{
	
	private List<Character> numbers;
	private List<Character> alphabet;
	
	public StringConverterImpl() {
		numbers = new ArrayList<Character>();
		alphabet = new ArrayList<Character>();
	}
	
	public String convert(String text, boolean removeTags) {
		if (removeTags)
			text = StringUtils.removeTags(text);
		parsingCharacters(text);
		Collections.sort(numbers);
		Collections.sort(alphabet, new Comparator<Character>() {
			public int compare(final Character c1, final Character c2) {
				if (Math.abs(c1 - c2) == 32)
					return c1 - c2;
				else
					return StringUtils.toAlphabetCode(c1) - StringUtils.toAlphabetCode(c2);
			}
		});
		return mergeCharacters();
	}
	
	private void parsingCharacters(String text) {
		char[] charArray = text.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			int code = charArray[i];
			if ((code >= 'a' && code <= 'z') || (code >= 'A' && code <= 'Z')) {
				alphabet.add(charArray[i]);
			} else if (code >= '0' && code <= '9') {
				numbers.add(charArray[i]);
			}
		}
	}
	 
	private String mergeCharacters() {
		int numIdx = 0;
		int alphabetIdx = 0;
		StringBuilder sb = new StringBuilder();
		while (numIdx < numbers.size() || alphabetIdx < alphabet.size()) {
			if (numIdx < numbers.size())
				sb.append(numbers.get(numIdx++));
			if (alphabetIdx < alphabet.size())
				sb.append(alphabet.get(alphabetIdx++));
		}
		return sb.toString();
	}
}
