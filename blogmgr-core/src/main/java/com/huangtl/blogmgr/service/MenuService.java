package com.huangtl.blogmgr.service;

import com.huangtl.blogmgr.dao.MenuDao;

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
}
