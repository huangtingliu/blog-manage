package com.huangtl.blog.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

import com.huangtl.framework.bean.RequestDataBean;
import com.huangtl.framework.bean.ResponseDataBean;
import com.huangtl.blog.mapper.BlogMapper;

/**
 *描述：登录模块
 *创建人:黄廷柳
 *创建日期：2016年1月25日 下午4:23:14
 **/
@Controller
public class BlogService {
	
	private static final Logger log = Logger.getLogger(BlogService.class);
	
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbc;
	@Autowired
	private BlogMapper blogMapper;
	
	/**
	 * 
	 * TODO 发布博文
	 * 作者：黄廷柳
	 * 2016年4月5日下午4:57:44
	 */
	public ResponseDataBean issueBlog(RequestDataBean rdb){
		log.info("发布博文...");
		ResponseDataBean responseDataBean=new ResponseDataBean();
		//blogMapper.issueBlog(rdb.getString("html"),rdb.getString("markdown"),rdb.getString("preview_html"),rdb.getString("author"));
		blogMapper.issueBlog(rdb);
		responseDataBean.setInfo("成功");
		responseDataBean.setStatus(ResponseDataBean.SUCCESSFUL);
		return responseDataBean;
	}
	
	/**
	 * 
	 * TODO 获取博文列表
	 * 作者：黄廷柳
	 * 2016年5月27日上午10:05:14
	 */
	public ResponseDataBean blogList(RequestDataBean rdb){
		log.info("获取博文列表...");
		ResponseDataBean responseDataBean=new ResponseDataBean();
		List<?> list = blogMapper.blogList(rdb);
		
		responseDataBean.setResultData(list);
		responseDataBean.setInfo("成功");
		responseDataBean.setStatus(ResponseDataBean.SUCCESSFUL);
		responseDataBean.setPage("blog/blogList");
		return responseDataBean;
	}
	
	public ResponseDataBean blogDetail(RequestDataBean rdb) {
		ResponseDataBean responseDataBean=new ResponseDataBean();
		Map<?, ?> map = blogMapper.blogDetail(rdb);
		
		responseDataBean.setResultData(map);
		responseDataBean.setInfo("成功");
		responseDataBean.setStatus(ResponseDataBean.SUCCESSFUL);
		responseDataBean.setPage("blog/blogDetail");
		return responseDataBean;
	}
	
}
