package com.huangtl.blogmgr.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.huangtl.blogmgr.core.spring.resolver.Json;
import com.huangtl.blogmgr.dao.where.PrivilegeSqlWhere;
import com.huangtl.blogmgr.model.blog.Privilege;
import com.huangtl.blogmgr.model.blog.Role;
import com.huangtl.blogmgr.model.blog.User;
import com.huangtl.blogmgr.model.blog.dictionary.AuthPriority;
import com.huangtl.blogmgr.model.blog.dictionary.FunctionType;
import com.huangtl.blogmgr.model.common.Message;
import com.huangtl.blogmgr.model.common.Page;
import com.huangtl.blogmgr.model.common.Page.Direction;
import com.huangtl.blogmgr.model.extjs.Filter;
import com.huangtl.blogmgr.model.extjs.FilterCollection;
import com.huangtl.blogmgr.model.extjs.Sort;
import com.huangtl.blogmgr.model.extjs.SortCollection;
import com.huangtl.blogmgr.service.PrivilegeService;

/**
 * 权限url接口层
 * @author PraiseLord
 * @date 2017年1月10日
 *
 */

@Controller
@RequestMapping("/privilege")
public class PrivilegeAction extends BlogMgrAction {
	private static Logger logger = LoggerFactory.getLogger(PrivilegeAction.class);
	@Resource
	private PrivilegeService privilegeService;
	
	/**
	 * 表格-分页查询权限
	 * @param pageNo
	 * @param pageSize
	 * @param filter
	 * @param sort
	 * @return
	 */
	@RequestMapping("paging.data")
	@ResponseBody
	public Object getPaging(Integer pageNo,Integer pageSize,
			FilterCollection filter,SortCollection sort) {
		
		Page<Privilege> page = new Page<>(pageNo, pageSize);
		if(sort.isEmpty()){
			page.addSort("fPriority", Direction.DESC);
		}else{
			for (Sort s : sort) {
				page.addSort(s.getProperty(), s.getDirection());
			}
		}
		
		PrivilegeSqlWhere whereParam = new PrivilegeSqlWhere();
		for (Filter f : filter) {
			whereParam.putFilter(f);
		}
		
		this.privilegeService.getDao().selectPaging(whereParam, page);
		
		JSONObject data = new JSONObject();
		data.put("privilegelist", page.getPageContent());
		data.put("total", page.getTotal());
		data.put("success", true);
		data.put("message", "获取成功个数 "+page.getTotal());
		return data;
	}
	
	/**
	 * 批量修改权限
	 * @param privileges
	 * @return
	 */
	@RequestMapping("editbatch.do")
	@ResponseBody
	public Object editBatchPrivilege(@Json List<Privilege> privileges){
		Message message = null;
		if(CollectionUtils.isEmpty(privileges)){return Message.error("无效参数");}
		for (Privilege privilege : privileges) {
			if(privilege==null || StringUtils.isBlank(privilege.getfId())){return Message.error("无效参数");}
			 message = privilege.checkValidity(true);
			 if(message.isError()){return message;}
		}
		
		try {
			message = this.privilegeService.editBatch(privileges);
		} catch (Exception e) {
			message = Message.exception("用户修改失败");
			logger.error("用户修改失败",e);
		}
		return message;
	}
	
	/**
	 * 树型分页查询权限
	 * @param parentId 
	 * @param filter
	 * @return
	 */
	@RequestMapping("tree.data")
	@ResponseBody
	public Object getTree(Integer pageNo,Integer pageSize,String parentId,FilterCollection filter
			,SortCollection sort){
		if(parentId.equalsIgnoreCase("root")){parentId="";}
		PrivilegeSqlWhere whereParam = new PrivilegeSqlWhere();
		for (Filter f : filter) {
			whereParam.putFilter(f);
		}
		whereParam.funParentIdEqual(parentId);
		JSONObject tree = this.privilegeService.getDao().selectPrivilegeTree(whereParam, 6);
		if(!parentId.equals("")){
			return tree.get("children");
		}
		return tree;
		
	}
	
	/**
	 * 根据当前用户的角色，将角色所持有的权限合并在一起
	 * @param functionId 功能id
	 * @param parentId   功能的父id
	 * @param type
	 * @return
	 */
	@RequestMapping("union_privilege.data")
	@ResponseBody
	public Object getExtractPrivilege(String functionId,String parentId,FunctionType type){
		List<Privilege> privileges = null;
		
		//获取当前角色
		@SuppressWarnings("unchecked")
		List<Role> roles = (List<Role>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		if(CollectionUtils.isEmpty(roles)){ //无权限处理
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			logger.error("当前用户:{}无权限",user.toString());
			privileges = new ArrayList<>();
		}else{
			List<String> roleIds = new ArrayList<>();
			for (int i = 0; i < roles.size(); i++) {
				roleIds.add(roles.get(i).getfId());
			}
			PrivilegeSqlWhere where = new PrivilegeSqlWhere().fPriorityNotEqual(AuthPriority.CLOSE);
			where.funParentIdEqual(parentId);
			where.fFunIdEqual(functionId);
			where.funTypeEqual(type);
			privileges = this.privilegeService.getDao().selectUnionPrivilege(roleIds, where,"funDescr");
		}
		
		JSONObject data = new JSONObject();
		data.put("privilegelist", privileges);
		data.put("success", true);
		data.put("message", "获取成功个数 "+privileges.size());
		return data;
	}
	
	
}
