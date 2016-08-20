package com.huangtl.blogmgr.service.impl;

import com.huangtl.blogmgr.dao.MenuDao;
import com.huangtl.blogmgr.model.blog.Menu;
import com.huangtl.blogmgr.model.common.Message;
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
	
	@Override
	public Message addMenu(Menu menu) {
		int effectRow = menuDao.insert(menu);
		return Message.get(effectRow, "添加成功", "添加失败");
	}



	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}
}
