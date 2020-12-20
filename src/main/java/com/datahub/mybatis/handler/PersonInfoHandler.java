package com.datahub.mybatis.handler;

import com.datahub.common.util.JsonUtil;
import com.datahub.domain.PersonInfo;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Create by HuQiuYue on 2020/10/26
 */
public class PersonInfoHandler extends BaseTypeHandler<PersonInfo> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, PersonInfo personInfo,
                                    JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, JsonUtil.toString(personInfo));
    }

    @Override
    public PersonInfo getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String sqlJson = resultSet.getString(s);
        if (sqlJson == null) {
            return null;
        }
        return JsonUtil.toObject(sqlJson, PersonInfo.class);
    }

    @Override
    public PersonInfo getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String sqlJson = resultSet.getString(i);
        if (sqlJson == null) {
            return null;
        }
        return JsonUtil.toObject(sqlJson, PersonInfo.class);
    }

    @Override
    public PersonInfo getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String sqlJson = callableStatement.getString(i);
        if (sqlJson == null) {
            return null;
        }
        return JsonUtil.toObject(sqlJson, PersonInfo.class);
    }
}
