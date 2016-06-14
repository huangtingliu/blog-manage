package com.huangtl.blog.mapper;

import java.util.List;
import java.util.Map;

import com.huangtl.framework.bean.RequestDataBean;

/**
 *描述：博客接口--mybatis映射类
 *创建人:黄廷柳
 *创建日期：2016年4月5日 下午4:51:36
 **/
public interface BlogMapper extends IMapper{
	/*public void issueBlog(@Param("html") String html,@Param("markdown") String markdown
			,@Param("preview_html") String preview_html,@Param("author") String author);*/
	public void issueBlog(RequestDataBean rdb);
	
	public List<?> blogList(RequestDataBean rdb);

	public Map<String, Object> blogDetail(RequestDataBean rdb);
}
