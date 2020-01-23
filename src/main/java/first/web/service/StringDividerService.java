package first.web.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import first.core.StringConverterImpl;
import first.core.StringDividerImpl;
import first.core.WebCrawlerImpl;
import first.web.vo.StringDividerVO;

@Service("stringDividerService")
public class StringDividerService {

	private Logger logger = LoggerFactory.getLogger(getClass());

	public Map<String, Object> process(StringDividerVO sdvo) throws Exception{
		Map<String, Object> r = new HashMap<String, Object>();
		String text = new WebCrawlerImpl().getRawText(sdvo.getTargetUrl());
		if(text.length() == 0 ) return r;
		boolean removeTags = "onlyText".equals(sdvo.getRemoveTags());
		text = new StringConverterImpl().convert(text, removeTags);
		String [] divided = new StringDividerImpl().divide(text, sdvo.getQuantity());
		r.put("dividedStr", divided);
		return r;
	}
}
