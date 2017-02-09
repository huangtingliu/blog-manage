package com.huangtl.blogmgr.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.aspose.cells.Workbook;
import com.aspose.cells.WorkbookDesigner;
import com.huangtl.blogmgr.core.aspose.AsposeCellUtils;
import com.huangtl.blogmgr.core.aspose.MapDataSource;
import com.huangtl.blogmgr.dao.RoleDao;
import com.huangtl.blogmgr.dao.UserDao;
import com.huangtl.blogmgr.dao.where.UserSqlWhere;
import com.huangtl.blogmgr.model.blog.Role;
import com.huangtl.blogmgr.model.blog.User;
import com.huangtl.blogmgr.model.blog.dictionary.ExportType;
import com.huangtl.blogmgr.model.blog.dictionary.UserStatus;
import com.huangtl.blogmgr.model.common.Message;
import com.huangtl.blogmgr.model.common.TwoTuple;
import com.huangtl.blogmgr.service.UserService;

/**
 * 后台用户业务层接口 - 默认实现
 * @date 2016年7月4日
 * @author PraiseLord
 */
public class UserServiceImpl implements UserService,ResourceLoaderAware {
	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	private final String ExcelTemplate = "/WEB-INF/template/excel/user_list.xlsx";
	
	private UserDao userDao;
	private RoleDao roleDao;
	
	private ResourceLoader resourceLoader;
	@Override
	public UserDao getDao() {
		return userDao;
	}

	/* 
	 * 1. 添加用户基础信息
	 * 2. 为用户添加权限
	 */
	@Override
	public Message addUser(User user) {
		logger.debug("添加用户{}",user);
		int effectRow = this.userDao.insert(user);
		
		Message.get(effectRow).throwIfError("系统异常,用户添加失败！");;
		
		//添加权限
		List<TwoTuple<String, String>> userRoles = new ArrayList<>();
		for (Role role : user.getRoles()) {
			userRoles.add(new TwoTuple<String, String>(user.getfId(), role.getfId()));
		}
		
		effectRow = this.roleDao.insertUserRole(userRoles);
		
		Message.get(effectRow).throwIfError("系统异常,用户角色添加失败！");;
		
		return Message.get(effectRow, "添加成功!", "添加失败!");
	}

	@Override
	public Message editUser(User user, UserSqlWhere where) {
		int effectRow = this.userDao.update(user, where);
		return Message.get(effectRow, "修改成功!", "修改失败!");
	}

	@Override
	public Message editBatchUser(List<User> users) {
		if(CollectionUtils.isEmpty(users)){return Message.error("参数为空");}
		
		int effectRow = this.userDao.updateBatch(users);
		Message message = Message.get(effectRow,"修改成功","修改失败");
		message.setAnnex(users.size());
		return message;
	}

	@Override
	public Message deleteUser(String... uids) {
		if(uids.length==0){return Message.error("未指定删除对象!");}
		int effectRow = this.userDao.deleteBatch(uids);
		return Message.get(effectRow, "成功删除"+uids.length+"个用户!", "删除失败!");
	}
	
	@Override
	public Message fakeDeleteUser(String... uids) {
		if(uids.length==0){return Message.error("未指定删除对象!");}
		
		List<User> entitys = new ArrayList<>();
		for (String userId : uids) {
			User user = new User();
			user.setfId(userId);
			user.setfStatus(UserStatus.DELETE);
			entitys.add(user);
		}
		
		int effectRow = this.userDao.updateBatch(entitys);
		
		return Message.get(effectRow, "成功删除"+uids.length+"个用户!", "删除失败!");
	}
	
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Override
	public Workbook exportExcel(ExportType type, String userIds) {
		if(type==null){throw new IllegalStateException("参数 ExportType 不能为空");}
		
		Resource templateResource = resourceLoader.getResource(this.ExcelTemplate);
		Workbook book;
		try {
			 book = new Workbook(templateResource.getInputStream());
		}  catch (Exception e) {
			logger.error("用户导出excel 失败",e);
			return new Workbook();
		}
		
		List<User> users;
		if (type == ExportType.ALL) {
			users = this.userDao.selectList(null);
		}else{
			if(StringUtils.isBlank(userIds)){
				return book;
			}
			UserSqlWhere where = new UserSqlWhere().fIdIn(userIds.split(","));
			users = this.userDao.selectList(where);
		}
		List<Map<String, Object>> mapList = new ArrayList<>();
		int rn = 0;
		for (User user : users) {
			rn++;
			Map<String, Object> map = AsposeCellUtils.toMap(user);
			map.put("rn", rn);
			mapList.add(map);
		}
		
		
		try {
			WorkbookDesigner designer = new WorkbookDesigner(book);
			designer.setDataSource("user", new MapDataSource(mapList));
			designer.setDataSource("date", new LocalDate().toString("yyyy-MM-dd"));
			designer.process(true);
		} catch (Exception e) {
			logger.error("aspose WorkbookDesigner 绑定数据失败",e);
		}
		return book;
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	
}
