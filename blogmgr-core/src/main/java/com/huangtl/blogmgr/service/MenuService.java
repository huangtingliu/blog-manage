package com.huangtl.blogmgr.service;

import java.util.List;

import com.huangtl.blogmgr.dao.MenuDao;
import com.huangtl.blogmgr.dao.where.MenuSqlWhere;
import com.huangtl.blogmgr.model.blog.Menu;
import com.huangtl.blogmgr.model.common.Message;

/**
 * 菜单业务接口
 * @date 2016年6月30日
 * @author PraiseLord
 */
public interface MenuService {
	/**
	 * 取得持久化对象
	 */
	public MenuDao getDao();
	
	/**
	 * 新增一个菜单<br>
	 * 必填字段：fId,fName,fType
	 * @param menu
	 * @return Message
	 */
	public Message addMenu(Menu menu);
	
	/**
	 * 修改一个菜单<br>
	 * 可修改字段：fName,fParentId,fIcon,fUrl,fViewClass,fType,fGlyph,fOrder,fUsability
	 * @param menu 如果menu字段不为null,那么将更新该字段。否则不更新
	 * @param where 更新条件
	 * @return Message
	 */
	public Message editMenu(Menu menu,MenuSqlWhere where);
	
	/**
	 * 根据fId批量的修改菜单
	 * @param menus
	 * @return 影响的记录数
	 */
	public Message editBatchMenu(List<Menu> menus);
	
}
