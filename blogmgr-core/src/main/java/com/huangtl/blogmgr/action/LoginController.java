package com.huangtl.blogmgr.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@RequestMapping("login.htm")
	private ModelAndView taskListPage() {
		ModelAndView view = new ModelAndView("login");
		return view;
	}
	
}
