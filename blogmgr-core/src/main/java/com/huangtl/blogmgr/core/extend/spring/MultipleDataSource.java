package com.huangtl.blogmgr.core.extend.spring;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 让spring 支持多数据源
 * @author PraiseLord
 * @date 2016年3月9日
 */
public class MultipleDataSource extends AbstractRoutingDataSource {
	private static final ThreadLocal<String> dataSourceKey = new InheritableThreadLocal<String>();

    public static void setDataSourceKey(String dataSource) {
        dataSourceKey.set(dataSource);
    }
	@Override
	protected Object determineCurrentLookupKey() {
		return dataSourceKey.get();
	}

}
