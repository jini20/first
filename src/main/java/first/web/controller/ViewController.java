package first.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import first.web.vo.StringDividerVO;

@Controller
public class ViewController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("/main.do")
	public String hello(HttpServletRequest request) {
		return "main";
	}
}
