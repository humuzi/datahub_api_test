package com.datahub.mybatis.handler;

import com.datahub.common.util.JsonUtil;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Create by HuQiuYue on 2020/10/26
 */
@MappedTypes(ArrayList.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class JsonArrayListHandler<T> extends BaseTypeHandler<Object> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setString(i, JsonUtil.toString(parameter));
    }

    @Override
    public Object getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String sqlJson = rs.getString(columnName);
        if (null != sqlJson) {
            return JsonUtil.toList(sqlJson, Object.class);
        }
        return new ArrayList<T>();
    }

    @Override
    public Object getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String sqlJson = rs.getString(columnIndex);
        if (null != sqlJson) {
            return JsonUtil.toList(sqlJson, Object.class);
        }
        return new ArrayList<T>();
    }

    @Override
    public Object getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String sqlJson = cs.getString(columnIndex);
        if (null != sqlJson) {
            return JsonUtil.toList(sqlJson, Object.class);
        }
        return new ArrayList<T>();
    }
}
