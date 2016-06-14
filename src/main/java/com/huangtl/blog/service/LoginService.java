package com.huangtl.blog.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

import com.huangtl.framework.bean.RequestDataBean;
import com.huangtl.framework.bean.ResponseDataBean;
import com.huangtl.blog.mapper.User;

/**
 *描述：登录模块
 *创建人:黄廷柳
 *创建日期：2016年1月25日 下午4:23:14
 **/
@Controller
public class LoginService {
	
	private static final Logger log = Logger.getLogger(LoginService.class);
	
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbc;
	@Autowired
	private User user;
	
//	public ModelAndView toLogin(Map<String, Object> model){
	public ResponseDataBean toLogin(RequestDataBean rdb){
		log.info("登录处理");
		ResponseDataBean responseDataBean=new ResponseDataBean();
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userName", "huangtl");
		map.put("age", "24");
		map.put("sex", "男");
		
		list.add(map);
		
		
		Map<String, Object> resultData = new HashMap<String, Object>();
		resultData.put("list",list);
		
		responseDataBean.setResultData(resultData);
		responseDataBean.setPage("login");//返回页面
		
		return responseDataBean;
	}
	
	/**
	 * TODO 登录
	 * 作者：黄廷柳
	 * 2016年1月29日上午11:49:13
	 */
	public ResponseDataBean login(RequestDataBean rdb){
		ResponseDataBean responseDataBean=new ResponseDataBean();
		String userName = rdb.getString("userName");
		String password = rdb.getString("password");
		
//		List<Map<String, Object>> List = jdbc.queryForList("select * from t_user");
		List<?> List = user.userList();
		Map<String, Object> userMap = new HashMap<String, Object>();
		userMap.put("userName", userName);
		userMap.put("password", password);
		userMap.put("list", List);
		
		responseDataBean.setResultData(userMap);
//		rdb.setPage("index");
		responseDataBean.setPage("markdown/md");
		return responseDataBean;
	}
	
	public static void main(String[] args) {
		int number = -8;
		System.out.println("原始:    "+Integer.toBinaryString(number)+"|"+number);
		System.out.println("左移:    "+Integer.toBinaryString(number << 4)+"|"+(number << 4));
		System.out.println("右移:    "+Integer.toBinaryString(number >> 4)+"|"+(number >> 4));
		System.out.println("无符号右移:"+Integer.toBinaryString(number >>> 4)+"|"+(number >>> 4));
	}
}
