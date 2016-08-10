package com.huangtl.blogmgr.service.impl;

import com.huangtl.blogmgr.dao.MenuDao;
import com.huangtl.blogmgr.service.MenuService;

/**
 * 菜单业务层接口 - 默认实现
 * @date 2016年6月30日
 * @author PraiseLord
 */
public class MenuServiceImpl implements MenuService {
	private MenuDao menuDao;
	
	@Override
	public MenuDao getDao() {
		return menuDao;
	}
	
	
	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}
}
