package com.huangtl.blogmgr.dao.where;

import java.util.Arrays;
import java.util.Date;

import com.huangtl.blogmgr.core.dao.Operator;
import com.huangtl.blogmgr.model.blog.dictionary.Gender;
import com.huangtl.blogmgr.model.blog.dictionary.UserStatus;

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
	public UserSqlWhere fIdEqual(String userId){
		this.put(Operator.eq.eval("fId"), userId);
		return this;
	}
	/**
	 * 指定用户id存在于
	 * @param userIds
	 * @return
	 */
	public UserSqlWhere fIdIn(String... userIds){
		if(userIds.length==0){return this;}
		this.put(Operator.in.eval("fId"), userIds);
		return this;
	}
	
	/**
	 * 用户名模糊查询
	 * @param userName
	 */
	public UserSqlWhere fNameLike(String userName){
		this.like(Operator.like.eval("fName"), userName);
		return this;
	}
	
	/**
	 * 拼音模糊查询
	 * @param pinYin
	 * @return
	 */
	public UserSqlWhere fPinYinLike(String pinYin ){
		this.like(Operator.like.eval("fPinYin"), pinYin);
		return this;
	}
	
	/**
	 * 指定账号为
	 * @param account
	 */
	public UserSqlWhere fAccountEqual(String account){
		this.put(Operator.eq.eval("fAccount"), account);
		return this;
	}
	/**
	 * 对账号进行模糊查询
	 * @param account
	 * @return
	 */
	public UserSqlWhere fAccountLike(String account){
		this.like(Operator.like.eval("fAccount"), account);
		return this;
	}
	
	/**
	 * 指定电话为
	 * @param phone
	 * @return
	 */
	public UserSqlWhere fPhoneEqual(String phone){
		this.put(Operator.eq.eval("fPhone"), phone);
		return this;
	}
	
	/**
	 * 模糊查询电话
	 * @param phone
	 * @return
	 */
	public UserSqlWhere fPhoneLike(String phone){
		this.like(Operator.like.eval("fPhone"), phone);
		return this;
	}
	
	/**
	 * 指定邮件为
	 * @param email
	 * @return
	 */
	public UserSqlWhere fEmailEqual(String email){
		this.put(Operator.eq.eval("fEmail"), email);
		return this;
	}
	
	/**
	 * 指定状态为
	 * @param status
	 */
	public UserSqlWhere fStatusEqual(UserStatus status){
		this.put(Operator.eq.eval("fStatus"), status);
		return this;
	}
	
	/**
	 * 指定状态不为
	 * @param status
	 */
	public UserSqlWhere fStatusNotEqual(UserStatus status){
		this.put(Operator.ne.eval("fStatus"), status);
		return this;
	}
	
	/**
	 * 指定状态 存在于
	 */
	public UserSqlWhere fStatusIn(UserStatus... status){
		if(status.length==0){return this;}
		
		this.put(Operator.in.eval("fStatus"), Arrays.asList(status));
		return this;
	}
	
	/**
	 * 性别为
	 * @param gender
	 */
	public UserSqlWhere fGenderEqual(Gender gender){
		this.put(Operator.eq.eval("fGender"), gender);
		return this;
	}
	
	/**
	 * 创建日期大于指定日期
	 * @param createDate
	 * @return
	 */
	public UserSqlWhere fCreateDateGreatThan(Date createDate){
		this.put(Operator.gt.eval("fCreateDate"), createDate);
		return this;
	}
	
	/**
	 * 创建日期小于指定日期
	 * @param createDate
	 * @return
	 */
	public UserSqlWhere fCreateDateLessThan(Date createDate){
		this.put(Operator.lt.eval("fCreateDate"), createDate);
		return this;
	}
	/**
	 * 创建日期为
	 * @param createDate
	 * @return
	 */
	public UserSqlWhere fCreateDateEqual(Date createDate){
		this.put(Operator.eq.eval("fCreateDate"), createDate);
		return this;
	}
}
