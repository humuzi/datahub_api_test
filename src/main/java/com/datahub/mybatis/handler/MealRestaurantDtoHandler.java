package com.datahub.mybatis.handler;

import com.datahub.common.dto.resDto.MealRestaurantDto;
import com.datahub.common.util.JsonUtil;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Create by HuQiuYue on 2020/11/19
 */

@MappedTypes(MealRestaurantDto.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class MealRestaurantDtoHandler extends BaseTypeHandler<MealRestaurantDto> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, MealRestaurantDto personInfo,
                                    JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, JsonUtil.toString(personInfo));
    }

    @Override
    public MealRestaurantDto getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String sqlJson = resultSet.getString(s);
        if (sqlJson == null) {
            return null;
        }
        return JsonUtil.toObject(sqlJson, MealRestaurantDto.class);
    }

    @Override
    public MealRestaurantDto getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String sqlJson = resultSet.getString(i);
        if (sqlJson == null) {
            return null;
        }
        return JsonUtil.toObject(sqlJson, MealRestaurantDto.class);
    }

    @Override
    public MealRestaurantDto getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String sqlJson = callableStatement.getString(i);
        if (sqlJson == null) {
            return null;
        }
        return JsonUtil.toObject(sqlJson, MealRestaurantDto.class);
    }
}
