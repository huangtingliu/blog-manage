package com.huangtl.blogmgr.service.impl;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.huangtl.blogmgr.dao.MenuDao;
import com.huangtl.blogmgr.dao.where.MenuSqlWhere;
import com.huangtl.blogmgr.model.blog.Menu;
import com.huangtl.blogmgr.model.common.Message;
import com.huangtl.blogmgr.service.MenuService;

/**
 * 菜单业务接口 - 默认实现
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
	
	@Override
	public Message editMenu(Menu menu, MenuSqlWhere where) {
		int effectRow = this.menuDao.update(menu, where);
		return Message.get(effectRow, "修改成功", "修改失败");
	}
	
	@Override
	public Message editBatchMenu(List<Menu> menus) {
		if(CollectionUtils.isEmpty(menus)){return Message.error("无效参数");}
		int effectRow = this.menuDao.updateBatch(menus);
		return Message.get(effectRow, "修改成功", "修改失败");
	}
	
	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	@Override
	public Message deleteMenu(String... fId) {
		if(fId==null || fId.length==0){return Message.error("无效参数");}
		
		MenuSqlWhere where = new MenuSqlWhere().fIdIn(fId);
		int effectRow = this.menuDao.delete(where);
		
		return Message.get(effectRow, "删除成功", "删除失败");
	}

	
}
