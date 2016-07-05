package com.huangtl.blogmgr.dao.param;

import com.huangtl.blogmgr.model.type.UserStatus;

@SuppressWarnings("serial")
public class UserParam extends WhereParam {
	public UserParam idEqual(String userId){
		this.put("userId", userId);
		return this;
	}
	
	public UserParam userNameEqual(String userName){
		this.put("userName", userName);
		return this;
	}
	
	public UserParam statusEqual(UserStatus status){
		this.put("status", status);
		return this;
	}
	
}
