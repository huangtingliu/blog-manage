package com.huangtl.blogmgr.action;


import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.aspose.cells.SaveFormat;
import com.aspose.cells.Workbook;
import com.huangtl.blogmgr.core.spring.resolver.Json;
import com.huangtl.blogmgr.core.util.PinYinUtils;
import com.huangtl.blogmgr.dao.where.UserSqlWhere;
import com.huangtl.blogmgr.model.blog.Role;
import com.huangtl.blogmgr.model.blog.User;
import com.huangtl.blogmgr.model.blog.dictionary.ExportType;
import com.huangtl.blogmgr.model.blog.dictionary.UserStatus;
import com.huangtl.blogmgr.model.common.Message;
import com.huangtl.blogmgr.model.common.Page;
import com.huangtl.blogmgr.model.common.Page.Direction;
import com.huangtl.blogmgr.model.extjs.Filter;
import com.huangtl.blogmgr.model.extjs.FilterCollection;
import com.huangtl.blogmgr.model.extjs.Sort;
import com.huangtl.blogmgr.model.extjs.SortCollection;
import com.huangtl.blogmgr.service.UserService;

/**
 * 后台用户url接口
 * @date 2016年7月4日
 * @author PraiseLord
 */
@Controller
@RequestMapping("/user")
public class UserAction extends BlogMgrAction {
	private static Logger logger = LoggerFactory.getLogger(UserAction.class);
	@Resource
	private UserService userService;
	
	/**
	 * 用户分页查询
	* @param pageNo 当前页号
	 * @param pageSize 每页记录个数 
	 * @param filter 查询过滤器 <br>
	 * <blockquote>
	 *  格式  filter:[{"property":"fName","value":"张三","operator":"like"}] 
	 *  </blockquote>
	 * @param sort 排序方案 <br>
	 * <blockquote>
	 *  格式   sort:[{"property":"fCreateDate","direction":"ASC\DESC"}]
	 * </blockquote>
	 * @return
	 * <pre>
	 * {message: "获取成功个数 15", total: 0, userlist: [], success: true}
	 * </pre>
	 * @return
	 * <pre>
	 * {
	 * 		message: "获取成功个数 15",
	 * 		total: 48,
	 * 		userlist: [{
			"fAccount":"ouiogyui",
			"fEmail":"",
			"fId":"09dbccec890a4fa8bcd6b71f360551f4",
			"fName":"uoyui",
			"fPhone":"",
			"fCreateDate":'',
			"fCreater":'root',
			"fGender":'MALE',
			"fStatus":"ENABLE"
		}],
	 * 		success: true
	 * }
	 * </pre>
	 */
	@RequestMapping("paging.data")
	@ResponseBody
	public Object getPaging( Integer pageNo, Integer pageSize,
			FilterCollection filter,SortCollection sort) {
		
		Page<User> page = new Page<>(pageNo, pageSize);
		if(sort.isEmpty()){
			page.addSort("fCreateDate", Direction.DESC);
		}else{
			for (Sort s : sort) {
				page.addSort(s.getProperty(), s.getDirection());
			}
		}
		
		UserSqlWhere whereParam = new UserSqlWhere();
		whereParam.fStatusNotEqual(UserStatus.DELETE);
		for (Filter f : filter) {
			whereParam.putFilter(f);
		}
		
		this.userService.getDao().selectPaging(whereParam, page,"fCreateDate","fGender","fCreater");
		
		JSONObject data = new JSONObject();
		data.put("userlist", page.getPageContent());
		data.put("total", page.getTotal());
		data.put("success", true);
		data.put("message", "获取成功个数 "+page.getPageSize());
		return data;
	}
	
	/**
	 * 获取常用用户
	 * @param userName
	 * @param pageNo
	 * @param pageSize
	 * @param sort
	 * @return
	 */
	@RequestMapping("useful_user.data")
	@ResponseBody
	public Object getUsefulUser(
			String userName,
			Integer pageNo,Integer pageSize,
			SortCollection sort){
		Page<User> page = new Page<>(pageNo, pageSize);
		if(sort.isEmpty()){
			page.addSort("fCreateDate", Direction.DESC);
		}else{
			for (Sort s : sort) {
				page.addSort(s.getProperty(), s.getDirection());
			}
		}
		
		UserSqlWhere whereParam = new UserSqlWhere();
		whereParam.fStatusNotEqual(UserStatus.DELETE);
		whereParam.fNameLike(userName);
		
		this.userService.getDao().selectPaging(whereParam, page,"fCreateDate","fGender","fCreater");
		
		JSONObject data = new JSONObject();
		data.put("userlist", page.getPageContent());
		data.put("total", page.getTotal());
		data.put("success", true);
		data.put("message", "获取成功个数 "+page.getPageSize());
		return data;
	}
	
	/**
	 * 单用户查询
	 * @param id 用户id
	 * @return
	 * <pre>
		{
			"fAccount":"ouiogyui",
			"fEmail":"",
			"fId":"09dbccec890a4fa8bcd6b71f360551f4",
			"fName":"uoyui",
			"fPhone":"",
			"fStatus":"ENABLE"
		}
	 * </pre>
	 */
	@RequestMapping("get.data")
	@ResponseBody
	public Object getUser(String id){
		UserSqlWhere whereParam = new UserSqlWhere();
		whereParam.fIdEqual(id).fStatusNotEqual(UserStatus.DELETE);
		
		User user = this.userService.getDao().selectOne(id);
		if(user==null){return "{}";}
		return user;
	}
	
	/**
	 * 添加用户<br>
	 * 必填字段：fId,fName,fAccount,fPassword,fPinYin,fCreater,fCreateDate
	 * @param user
	 * @param accountType 账号类型,默认为:custom 
	 * <li>custom  自定义
	 * <li>mail    邮箱
	 * <li>phone   手机
	 * @return
	 */
	@RequestMapping("add.do")
	@ResponseBody
	public Object addUser(String accountType,User user,@RequestParam List<String> roleIds) {
		if(user==null){return Message.error("参数为空");}
		if(CollectionUtils.isEmpty(roleIds)){
			return Message.error("未为用户分配权限");
		}
		
		List<Role> roles = new ArrayList<>();
		for (String roleId : roleIds) {
			Role role = new Role();
			role.setfId(roleId);
			roles.add(role);
		}
		user.setRoles(roles);
		
		Message message = null;
		user.setfId(user.newId());
		user.setfPinYin(PinYinUtils.toPinYin(user.getfName())); 
		user.setfCreateDate(new Date());
		user.setfCreater("root");
		if(accountType.equals("mail")){
			user.setfAccount(user.getfEmail());
			message = user.checkValidity(false,"fAccount");
		}else if(accountType.equals("phone")){
			user.setfAccount(user.getfPhone());
			message = user.checkValidity(false,"fAccount");
		}else{
			message = user.checkValidity();
		}
		
		if(message.isError()){return message;}
		     
		user.setfPassword(DigestUtils.md5Hex(user.getfPassword()));  
			
		try {
			message =  this.userService.addUser(user);
		} catch (Exception e) {
			logger.error("用户添加失败",e);
			message = Message.exception("用户添加失败");
		}
		return message;
	}
	
	/**
	 * 删除多名用户
	 * @param id 用户id  格式： 'id,id,id,...'
	 * @return 删除的人数
	 */
	@RequestMapping("delete.do")
	@ResponseBody
	public Object deleteUser(String id){
		if(StringUtils.isBlank(id)){return Message.error("无效参数!");}
		
		Message message = null;
		 try {
			 message = this.userService.fakeDeleteUser(id.split(","));
		} catch (Exception e) {
			logger.error("用户删除失败",e);
			message = Message.exception("用户删除失败");
		}
		 return message;
	}
	
	/**
	 * 根据用户的fId,批量修改每个用户,规则：参见editUser<br>
	 * @param user 格式：<br>
	 <pre>
		[{
		 	fId:'',
		 	fName:'',
		 	...
		 },{
		 	...
		 }]
	 </pre>
	 * @return 修改成功的人数
	 */
	@RequestMapping("editbatch.do")
	@ResponseBody
	public Object editBatchUser(@Json List<User> users){
		Message message = null;
		if(CollectionUtils.isEmpty(users)){return Message.error("无效参数");}
		for (User user : users) {
			if(user==null || StringUtils.isBlank(user.getfId())){return Message.error("无效参数");}
			 message = user.checkValidity(true);
			 if(message.isError()){return message;}
		}
		
		try {
			message = this.userService.editBatchUser(users);
		} catch (Exception e) {
			message = Message.exception("用户修改失败");
			logger.error("用户修改失败",e);
		}
		return message;
	}
	
	/**
	 * 根据fId,修改单个用户<br> 
	 * 规则：<br>
	 * <li>可修改字段：fName,fPassword,fStatus,fPinYin,fDescr,fEditor,fEditDate,fEmail,fPhone,fGender
	 * <li>只修改非null的字段
	 * @param user 
	 * @return
	 */
	@RequestMapping("edit.do")
	@ResponseBody
	public Object editUser(User user){
		if(user==null || StringUtils.isBlank(user.getfId())){return Message.error("无效参数");}
		
		Message message = user.checkValidity(true);
		if(message.isError()){return message;}
		
		UserSqlWhere sqlWhere = new UserSqlWhere()
				.fIdEqual(user.getfId());
		try {
			message = this.userService.editUser(user, sqlWhere);
		} catch (Exception e) {
			message = Message.exception("用户修改失败");
			logger.error("用户修改失败",e);
		}
		
		return message;
	}
	
	/**
	 * 导出用户
	 * @param type
	 * @param userIds 格式： ‘id,id,id’
	 * @throws IOException 
	 */
	@RequestMapping("export_user_list.data")
	public Object exportExcel( ExportType type,String userIds,HttpServletResponse response) throws IOException{
		if(type==null){
			return Message.error("缺少参数：type");
		}
		
		OutputStream oStream =  response.getOutputStream();
		String fileName = "用户清单";
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName + ".xlsx").getBytes(), "iso-8859-1"));
		
		try {
			Workbook book= this.userService.exportExcel(type, userIds);
			book.save(oStream, SaveFormat.XLSX);
			return null;
		}  catch (Exception e) {
			logger.error("用户导出excel失败",e);
		}
		
		try {
			Workbook book= new Workbook();
			book.save(oStream, SaveFormat.XLSX);
		} catch (Exception e) {}
		
		return Message.error("导出失败");
	}
	
}
