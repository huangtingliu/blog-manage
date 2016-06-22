package com.huangtl.blogmgr.core.util;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;

import org.apache.commons.collections.CollectionUtils;

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
	 * @param entity
	 * @return
	 */
	public static <T> Message validate(T entity){
		Set<ConstraintViolation<T>> validateSet = validator.validate(entity, Default.class);
		if( CollectionUtils.isNotEmpty(validateSet) ){
			for (ConstraintViolation<T> cv : validateSet) {
				return Message.warn(cv.getMessage());
			}
		}
		return Message.SUCCESS;
	}
	
	/**
	 * 根据指定的验证器,验证实体是否满足约束条件
	 * @param entity
	 * @return
	 */
	public static <T> Message validate(T entity,Validator validator){
		Set<ConstraintViolation<T>> validateSet = validator.validate(entity, Default.class);
		if( CollectionUtils.isNotEmpty(validateSet) ){
			for (ConstraintViolation<T> cv : validateSet) {
				return Message.warn(cv.getMessage());
			}
		}
		return Message.SUCCESS;
	}
	
	/**
	 * 验证某个字段是否满足约束条件
	 * @param entity
	 * @param propertyName
	 * @return
	 */
	public static <T> Message validateProperty(T entity,String propertyName){
	     Set<ConstraintViolation<T>> set = validator.validateProperty(entity,propertyName,Default.class);
	     if( CollectionUtils.isNotEmpty(set) ){
	       for(ConstraintViolation<T> cv : set){
	    	   return Message.warn(cv.getMessage());
	       }
	     }
	     return Message.SUCCESS;
	  }
}
