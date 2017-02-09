package com.huangtl.blogmgr.core.aspose;

import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Aspose Cells 工具类
 * @author PraiseLord
 * @date 2017年2月9日
 *
 */
public final class AsposeCellUtils {
	private final static Logger logger = LoggerFactory.getLogger(AsposeCellUtils.class);
	
	/**
	 * 将对象实体转成map形式
	 * @param object
	 * @return 失败返回null
	 */
	public static Map<String, Object> toMap(Object entity){
		try {
			return PropertyUtils.describe(entity);
		} catch (Exception e) {
			logger.error("对象转map失败", e);
		} 
		return null;
	}
}
