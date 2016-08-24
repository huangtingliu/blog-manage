package com.huangtl.blogmgr.core.util;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

import com.huangtl.blogmgr.model.common.Message;

/**
 * 实体验证器
 * @version 
 * @date 2016年3月29日
 * @author PraiseLord
 */
public final class ValidationUtils {
	private final static Validator validator;
	static{
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}
	
	/**
	 * 验证实体是否满足约束条件
	 * @param entity 被验证的实体
	 * @param allowNull 总的设置是否验证为空字段,即忽略个别字段有@notNull的约束。默认false,将验证为null的字段
	 * @param exceptFields 排除不验证的字段,默认验证所有的字段
	 * @return 成功返回Message.success，否则Message.error
	 */
	public static <T> Message validate(T entity,boolean allowNull,String... exceptFields){
		Set<ConstraintViolation<T>> validateSet = validator.validate(entity, Default.class);
		
		if( CollectionUtils.isNotEmpty(validateSet) ){
			for (ConstraintViolation<T> cv : validateSet) {
				//排除为空的字段
				if(allowNull && cv.getInvalidValue()==null ){continue;}
				//排除指定排除的字段
				if( ArrayUtils.contains(exceptFields, cv.getPropertyPath().toString())){continue;}
				return Message.error(cv.getMessage());
			}
		}
		return Message.success("验证成功");
	}
	
	/**
	 * 根据指定的验证器,验证实体是否满足约束条件
	 * @param entity 被验证的实体
	 * @param validator 自定义验证器
	 * @return 成功返回Message.success，否则Message.error
	 */
	public static <T> Message validate(T entity,Validator validator){
		Set<ConstraintViolation<T>> validateSet = validator.validate(entity, Default.class);
		if( CollectionUtils.isNotEmpty(validateSet) ){
			for (ConstraintViolation<T> cv : validateSet) {
				return Message.error(cv.getMessage());
			}
		}
		return Message.SUCCESS;
	}
	
	/**
	 * 验证实体中的某个字段是否满足约束条件
	 * @param entity 被验证的实体
	 * @param propertyName  被验证的实体中的某个字段
	 * @return 成功返回Message.success，否则Message.error
	 */
	public static <T> Message validateProperty(T entity,String propertyName){
	     Set<ConstraintViolation<T>> set = validator.validateProperty(entity,propertyName,Default.class);
	     if( CollectionUtils.isNotEmpty(set) ){
	       for(ConstraintViolation<T> cv : set){
	    	   return Message.error(cv.getMessage());
	       }
	     }
	     return Message.SUCCESS;
	  }
}
