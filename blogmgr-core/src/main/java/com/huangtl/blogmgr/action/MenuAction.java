package com.huangtl.blogmgr.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huangtl.blogmgr.dao.param.MenuParam;
import com.huangtl.blogmgr.dao.param.WhereParam;
import com.huangtl.blogmgr.model.blog.Menu;
import com.huangtl.blogmgr.service.MenuService;

/**
 * 菜单管理url接口
 * @date 2016年6月30日
 * @author PraiseLord
 */
@Controller
@RequestMapping("/menu/*")
public class MenuAction extends BlogMgrAction {
	@Resource
	private MenuService menuService;
	
	/**
	 * 主页面
	 * @return
	 */
	@RequestMapping("menus.data")
	@ResponseBody
	private Object menuSearch(String menuId,String parentId) {
		WhereParam param = new MenuParam()
						  .idEqual(menuId)
						  .parentIdEqual("");
		List<Menu> menus = this.menuService.getDao().selectList(param);
		return menus;
	}
}
