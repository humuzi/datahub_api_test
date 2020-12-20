package com.datahub.mybatis.handler;

import com.datahub.common.dto.resDto.MealFoodDto;
import com.datahub.common.util.JsonUtil;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Create by HuQiuYue on 2020/11/19
 */
public class FoodInfoHandler extends JsonArrayListHandler<MealFoodDto> {
    @Override
    public Object getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String sqlJson = rs.getString(columnName);
        if (sqlJson == null) {
            return new ArrayList<>();
        }
        return JsonUtil.toList(sqlJson, MealFoodDto.class);
    }

    @Override
    public Object getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String sqlJson = rs.getString(columnIndex);
        if (sqlJson == null) {
            return new ArrayList<>();
        }
        return JsonUtil.toList(sqlJson, MealFoodDto.class);
    }

    @Override
    public Object getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String sqlJson = cs.getString(columnIndex);
        if (sqlJson == null) {
            return new ArrayList<>();
        }
        return JsonUtil.toList(sqlJson, MealFoodDto.class);
    }
}
