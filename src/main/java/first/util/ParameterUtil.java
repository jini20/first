package first.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import first.StringDividerException;
import first.web.vo.StringDividerVO;

public class ParameterUtil {
	
	static final String urlCheckRegex = "^((http|https)://)?(www.)?([a-zA-Z0-9]+)\\.[a-z]+([a-zA-z0-9.?#]+)?";
	static final Pattern urlPattern = Pattern.compile(urlCheckRegex);

	private ParameterUtil(){}
				
	public static boolean checkParams(StringDividerVO sdvo) {		
		Matcher m = urlPattern.matcher(sdvo.getTargetUrl());
		if(!m.matches()) throw new StringDividerException("The url is not valid.");
		return true;
	}
}
