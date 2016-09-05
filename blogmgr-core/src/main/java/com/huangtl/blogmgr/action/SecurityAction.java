package com.huangtl.blogmgr.action;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.huangtl.blogmgr.model.common.Message;

/**
 * 系统安全中心url接口
 * @date 2016年9月5日
 * @author PraiseLord
 */
@Controller
@RequestMapping("/")
public class SecurityAction extends BlogMgrAction {
	
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
	 * 登录
	 * @param account 账号
	 * @param password 密码
	 * @param vCode 验证码
	 * @return
	 */
	@ResponseBody
	@RequestMapping("login.do")
	public Object signin(String account,String password,String vCode){
		if(StringUtils.isBlank(account)){
			return Message.error("账号为空");
		}
		if(StringUtils.isBlank(password)){
			return Message.error("密码为空");
		}
		return Message.success("登录成功");
	}
	
}
