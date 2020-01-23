package first.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import first.util.ParameterUtil;
import first.web.service.StringDividerService;
import first.web.vo.StringDividerVO;

@Controller
public class RequestController {

	@Resource(name = "stringDividerService")
	StringDividerService stringDividerService;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("/submit.do")
	public ModelAndView submit(StringDividerVO sdvo,
			HttpServletRequest request, HttpServletResponse response){
		try {
			ParameterUtil.checkParams(sdvo);
			Map<String, Object> divided = stringDividerService.process(sdvo);
			return new ModelAndView("jsonViewResolver", divided);
		} catch (Exception e){
			logger.error(e.getLocalizedMessage());
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return new ModelAndView("jsonViewResolver");
		}		
	}

}
