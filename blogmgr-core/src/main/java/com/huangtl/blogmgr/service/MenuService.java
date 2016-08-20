package com.huangtl.blogmgr.service;

import com.huangtl.blogmgr.dao.MenuDao;
import com.huangtl.blogmgr.model.blog.Menu;
import com.huangtl.blogmgr.model.common.Message;

/**
 * 菜单业务层接口
 * @date 2016年6月30日
 * @author PraiseLord
 */
public interface MenuService {
	/**
	 * 取得持久化对象
	 */
	public MenuDao getDao();
	
	/**
	 * 新增一个菜单
	 * @param menu
	 * @return
	 */
	public Message addMenu(Menu menu);
}
