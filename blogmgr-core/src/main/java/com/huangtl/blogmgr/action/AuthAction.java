package com.huangtl.blogmgr.action;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.huangtl.blogmgr.dao.where.RoleSqlWhere;
import com.huangtl.blogmgr.model.blog.Role;
import com.huangtl.blogmgr.model.blog.dictionary.CommonDictionary.Usability;
import com.huangtl.blogmgr.model.common.Message;
import com.huangtl.blogmgr.model.common.Page;
import com.huangtl.blogmgr.model.common.Page.Direction;
import com.huangtl.blogmgr.model.extjs.Filter;
import com.huangtl.blogmgr.model.extjs.FilterCollection;
import com.huangtl.blogmgr.model.extjs.Sort;
import com.huangtl.blogmgr.model.extjs.SortCollection;
import com.huangtl.blogmgr.service.AuthService;

/**
 * 权限配置url接口
 * @author PraiseLord
 * @date 2017年1月7日
 *
 */
@Controller
@RequestMapping("/auth")
public class AuthAction extends BlogMgrAction {
	private static Logger logger = LoggerFactory.getLogger(AuthAction.class);
	
	@Resource
	private AuthService authService;
	
	/**
	 * 角色分布查询数据
	 * @param pageNo
	 * @param pageSize 默认页面数据15条
	 * @param filter 
	 * @param sort  默认接角色名称排序
	 * @return
	 */
	@ResponseBody
	@RequestMapping("role_paging.data")
	public Object getPaging(Integer pageNo,Integer pageSize,
			FilterCollection filter,SortCollection sort) {
		
		Page<Role> page = new Page<>(pageNo,pageSize);
		if(sort==null || sort.isEmpty()){
			page.addSort("fName", Direction.ASC);
		}else{
			for (Sort s : sort) {
				page.addSort(s.getProperty(), s.getDirection());
			}
		}
		
		RoleSqlWhere whereParam = new RoleSqlWhere().fStatusNotEqual(Usability.DELETE);
		if(filter!=null && !filter.isEmpty()){
			for (Filter f : filter) {
				whereParam.putFilter(f);
			}
		}
		
		this.authService.getDao().selectPaging(whereParam, page);
		
		JSONObject data = new JSONObject();
		data.put("rolelist", page.getPageContent());
		data.put("total", page.getTotal());
		data.put("success", true);
		data.put("message", "获取成功个数 "+page.getPageSize());
		return data;
	}
	
	@RequestMapping("role_get.data")
	@ResponseBody
	public Object getUser(String id){
		RoleSqlWhere whereParam = new RoleSqlWhere();
		whereParam.fIdEqual(id);
		Role role = this.authService.getDao().selectOne(id);
		if(role==null){return "{}";}
		return role;
	}
	
	/**
	 * 伪删除指定的角色
	 * @param id   规则：id,id,id
	 * @return
	 */
	@RequestMapping("role_delete.do")
	@ResponseBody
	public Object fakeDeleteRole(String id){
		logger.debug("将要删除角色，角色的id为：{}",id);
		return Message.info("功能未实现");
	}
	
	
	@RequestMapping("role_add.do")
	@ResponseBody
	public Object addRole(Role role){
		if(role==null){
			return Message.error("无效的参数");
		}
		role.setfId(role.newId());
		role.setfStatus(Usability.ENABLE);
		
		Message message = role.checkValidity();
		if(message.isError()){
			return message;
		}
		
		message = this.authService.addRole(role);
		return message;
	}
	
}
