package com.huangtl.blogmgr.core.mybatis.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.huangtl.blogmgr.model.common.TwoTuple;

/**
 * map的类型映射只处理get一面的。取值(set)这面无法获取
 * @date 2016年8月11日
 * @author PraiseLord
 */
public class MapTypeHandler extends BaseTypeHandler<TwoTuple<String, Object>> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, TwoTuple<String, Object> parameter, JdbcType jdbcType)
			throws SQLException {
		throw new UnsupportedOperationException("map映射只用来获取数据");
	}

	@Override
	public TwoTuple<String, Object> getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return new TwoTuple<String, Object>(columnName, rs.getObject(columnName));
	}

	@Override
	public TwoTuple<String, Object> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return new TwoTuple<String, Object>("attr"+columnIndex, rs.getObject(columnIndex));
	}

	@Override
	public TwoTuple<String, Object> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return new TwoTuple<String, Object>("attr"+columnIndex, cs.getObject(columnIndex));
	}

	

	

}
