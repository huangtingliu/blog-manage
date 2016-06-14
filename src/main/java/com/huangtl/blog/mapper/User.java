package com.huangtl.blog.mapper;

import java.util.List;
import java.util.Map;



/**
 *描述：用户类接口--mybatis映射类
 *创建人:黄廷柳
 *创建日期：2016年3月25日 下午3:16:26
 **/
public interface User extends IMapper{
	public List<Map<String, Object>> userList();
}
