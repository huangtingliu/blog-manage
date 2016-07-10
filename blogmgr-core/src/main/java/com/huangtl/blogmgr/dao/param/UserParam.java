package com.huangtl.blogmgr.dao.param;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.huangtl.blogmgr.model.type.Gender;
import com.huangtl.blogmgr.model.type.UserStatus;

/**
 * 后台用户查询条件参数集
 * @date 2016年7月10日
 * @author PraiseLord
 */
@SuppressWarnings("serial")
public class UserParam extends WhereParam {
	/**
	 * 为指定用户id
	 * @param userId
	 */
	public UserParam idEqual(String userId){
		this.put("userId", userId);
		return this;
	}
	
	public UserParam idIn(List<String> userIds){
		this.put("userIds", userIds);
		return this;
	}
	
	/**
	 * 符合指定用户名
	 * @param userName
	 */
	public UserParam userNameLike(String userName){
		if(StringUtils.isNotBlank(userName)){
			this.put("userName", "%"+userName);
		}
		return this;
	}
	
	/**
	 * 符合指定拼音
	 * @param pinYin
	 * @return
	 */
	public UserParam pinYinLike(String pinYin ){
		if(StringUtils.isNotBlank(pinYin)){
			this.put("pinYin", "%"+pinYin);
		}
		return this;
	}
	
	/**
	 * 为指定账号
	 * @param account
	 */
	public UserParam accountEqual(String account){
		this.put("account", account);
		return this;
	}
	
	/**
	 * 为指定电话
	 * @param phone
	 * @return
	 */
	public UserParam phoneEqual(String phone){
		this.put("phone", phone);
		return this;
	}
	
	/**
	 * 为指定邮件
	 * @param email
	 * @return
	 */
	public UserParam emailEqual(String email){
		this.put("email", email);
		return this;
	}
	
	/**
	 * 为指定状态
	 * @param status
	 */
	public UserParam statusEqual(UserStatus status){
		this.put("status", status);
		return this;
	}
	
	/**
	 * 不为指定状态
	 * @param status
	 */
	public UserParam statusNotEqual(UserStatus status){
		this.put("statusNot", status);
		return this;
	}
	
	/**
	 * 为指定性别
	 * @param gender
	 */
	public UserParam genderEqual(Gender gender){
		this.put("gender", gender);
		return this;
	}
	
}
