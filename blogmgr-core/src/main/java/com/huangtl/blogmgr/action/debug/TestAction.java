package com.huangtl.blogmgr.action.debug;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/debug/test")
public class TestAction {

	private final static Logger logger = LoggerFactory.getLogger(TestAction.class);
	
	@RequestMapping("send.do")
	@ResponseBody
	public Object getMemo(String content){
		logger.debug(content);
		return "{}";
	}
	
}
