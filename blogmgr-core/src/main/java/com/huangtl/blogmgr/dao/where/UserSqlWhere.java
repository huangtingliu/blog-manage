package com.huangtl.blogmgr.dao.where;

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
public class UserSqlWhere extends SqlWhere {
	/**
	 * 为指定用户id
	 * @param userId
	 */
	public UserSqlWhere idEqual(String userId){
		this.put("fId_eq", userId);
		return this;
	}
	
	public UserSqlWhere idIn(List<String> userIds){
		this.put("fId_in", userIds);
		return this;
	}
	
	/**
	 * 符合指定用户名
	 * @param userName
	 */
	public UserSqlWhere userNameLike(String userName){
		if(StringUtils.isNotBlank(userName)){
			this.put("fName_like", "%"+userName);
		}
		return this;
	}
	
	/**
	 * 符合指定拼音
	 * @param pinYin
	 * @return
	 */
	public UserSqlWhere pinYinLike(String pinYin ){
		if(StringUtils.isNotBlank(pinYin)){
			this.put("fPinYin_like", "%"+pinYin);
		}
		return this;
	}
	
	/**
	 * 为指定账号
	 * @param account
	 */
	public UserSqlWhere accountEqual(String account){
		this.put("fAccount_eq", account);
		return this;
	}
	
	/**
	 * 为指定电话
	 * @param phone
	 * @return
	 */
	public UserSqlWhere phoneEqual(String phone){
		this.put("fPhone_eq", phone);
		return this;
	}
	
	/**
	 * 为指定邮件
	 * @param email
	 * @return
	 */
	public UserSqlWhere emailEqual(String email){
		this.put("fEmail_eq", email);
		return this;
	}
	
	/**
	 * 为指定状态
	 * @param status
	 */
	public UserSqlWhere statusEqual(UserStatus status){
		this.put("fStatus_eq", status);
		return this;
	}
	
	/**
	 * 不为指定状态
	 * @param status
	 */
	public UserSqlWhere statusNotEqual(UserStatus status){
		this.put("fStatus_ne", status);
		return this;
	}
	
	/**
	 * 为指定性别
	 * @param gender
	 */
	public UserSqlWhere genderEqual(Gender gender){
		this.put("fGender_eq", gender);
		return this;
	}
	
}
