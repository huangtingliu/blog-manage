package com.huangtl.blogmgr.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeAction {
	
	@RequestMapping("home.htm")
	private ModelAndView taskListPage() {
		ModelAndView view = new ModelAndView("home");
		return view;
	}

}
