package first;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import first.util.StringUtils;

public class StringUtilsTest {

	@Test
	public void testRemoveTags() {
		String htmlStr = "<div class='user-action-time'>     answered";
		String r = StringUtils.removeTags(htmlStr);
		assertFalse("include < or >!", r.contains("<") || r.contains(">"));
	}

}
