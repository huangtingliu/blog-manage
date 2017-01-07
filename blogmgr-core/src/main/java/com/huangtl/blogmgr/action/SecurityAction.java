package com.huangtl.blogmgr.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * 系统安全中心url接口,处理登录操作（包括登录成功，及登录未成功的处理）
 * @date 2016年9月5日
 * @author PraiseLord
 */
@Controller
@RequestMapping("/")
public class SecurityAction extends BlogMgrAction  {
	
	//private final Logger logger = LoggerFactory.getLogger(SecurityAction.class);
	
	/**
	 * 用户登录页面
	 * @return
	 */
	@RequestMapping("login.htm")
	private ModelAndView loginPage() {
		ModelAndView view = new ModelAndView("login");
		return view;
	}
	
	/**
	 * 无权限页面
	 * @return
	 */
	@RequestMapping("noauth.htm")
	private ModelAndView accessDenied(){
		ModelAndView view = new ModelAndView("noauth");
		return view;
	}
	
	

	
}
