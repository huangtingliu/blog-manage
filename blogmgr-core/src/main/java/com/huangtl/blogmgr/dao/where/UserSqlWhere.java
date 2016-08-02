package com.huangtl.blogmgr.dao.where;

import java.util.Arrays;
import java.util.Date;
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
	 * 指定用户id为
	 * @param userId
	 */
	public UserSqlWhere idEqual(String userId){
		this.put("fId_eq", userId);
		return this;
	}
	/**
	 * 指定用户id存在于
	 * @param userIds
	 * @return
	 */
	public UserSqlWhere idIn(List<String> userIds){
		this.put("fId_in", userIds);
		return this;
	}
	
	/**
	 * 用户名模糊查询
	 * @param userName
	 */
	public UserSqlWhere userNameLike(String userName){
		this.like("fName_like", userName);
		return this;
	}
	
	/**
	 * 拼音模糊查询
	 * @param pinYin
	 * @return
	 */
	public UserSqlWhere pinYinLike(String pinYin ){
		this.like("fPinYin_like", pinYin);
		return this;
	}
	
	/**
	 * 指定账号为
	 * @param account
	 */
	public UserSqlWhere accountEqual(String account){
		this.put("fAccount_eq", account);
		return this;
	}
	/**
	 * 对账号进行模糊查询
	 * @param account
	 * @return
	 */
	public UserSqlWhere accountLike(String account){
		this.like("fAccount_like", account);
		return this;
	}
	
	/**
	 * 指定电话为
	 * @param phone
	 * @return
	 */
	public UserSqlWhere phoneEqual(String phone){
		this.put("fPhone_eq", phone);
		return this;
	}
	
	/**
	 * 指定邮件为
	 * @param email
	 * @return
	 */
	public UserSqlWhere emailEqual(String email){
		this.put("fEmail_eq", email);
		return this;
	}
	
	/**
	 * 指定状态为
	 * @param status
	 */
	public UserSqlWhere statusEqual(UserStatus status){
		this.put("fStatus_eq", status);
		return this;
	}
	
	/**
	 * 指定状态不为
	 * @param status
	 */
	public UserSqlWhere statusNotEqual(UserStatus status){
		this.put("fStatus_ne", status);
		return this;
	}
	
	public UserSqlWhere statusIn(UserStatus... status){
		if(status==null || status.length==0){return this;}
		
		this.put("fStatus_in", Arrays.asList(status));
		return this;
	}
	
	/**
	 * 性别为
	 * @param gender
	 */
	public UserSqlWhere genderEqual(Gender gender){
		this.put("fGender_eq", gender);
		return this;
	}
	
	/**
	 * 创建日期大于指定日期
	 * @param createDate
	 * @return
	 */
	public UserSqlWhere createDateGreatThan(Date createDate){
		this.put("fCreateDate_gt", createDate);
		return this;
	}
	
	/**
	 * 创建日期小于指定日期
	 * @param createDate
	 * @return
	 */
	public UserSqlWhere createDateLessThan(Date createDate){
		this.put("fCreateDate_lt", createDate);
		return this;
	}
	/**
	 * 创建日期为
	 * @param createDate
	 * @return
	 */
	public UserSqlWhere createDateEqual(Date createDate){
		this.put("fCreateDate_eq", createDate);
		return this;
	}
	
	public static void main(String[] args) {
		System.out.println(StringUtils.trimToNull(null));
	}
}
