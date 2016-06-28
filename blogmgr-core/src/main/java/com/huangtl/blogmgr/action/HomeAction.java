package com.huangtl.blogmgr.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 系统主页
 * @version 
 * @date 2016年6月28日
 * @author PraiseLord
 */
@Controller
@RequestMapping("/")
public class HomeAction {
	
	/**
	 * 主页面
	 * @return
	 */
	@RequestMapping("home.htm")
	private ModelAndView homePage() {
		ModelAndView view = new ModelAndView("home");
		return view;
	}
	
	/**
	 * 主页默认页面
	 * @return
	 */
	@RequestMapping("home/index.htm")
	private ModelAndView homeIndexPage() {
		ModelAndView view = new ModelAndView("home/index");
		return view;
	}

}
