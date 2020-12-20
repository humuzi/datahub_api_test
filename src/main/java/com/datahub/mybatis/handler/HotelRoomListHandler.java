package com.datahub.mybatis.handler;

import com.datahub.common.util.JsonUtil;
import com.datahub.domain.HotelRoom;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;

/**
 * Create by HuQiuYue on 2020/10/26
 */
public class HotelRoomListHandler extends JsonArrayListHandler<HotelRoom> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        super.setNonNullParameter(ps, i, parameter, jdbcType);
    }

    @Override
    public Object getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String sqlJson = rs.getString(columnName);
        if (sqlJson == null) {
            return Collections.emptyList();
        }
        return JsonUtil.toList(sqlJson, HotelRoom.class);
    }

    @Override
    public Object getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String sqlJson = rs.getString(columnIndex);
        if (sqlJson == null) {
            return Collections.emptyList();
        }
        return JsonUtil.toList(sqlJson, HotelRoom.class);
    }

    @Override
    public Object getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String sqlJson = cs.getString(columnIndex);
        if (sqlJson == null) {
            return Collections.emptyList();
        }
        return JsonUtil.toList(sqlJson, HotelRoom.class);
    }
}
