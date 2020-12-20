package com.datahub.web.steps;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.datahub.common.constant.Constant;
import com.datahub.common.util.DateUtil;
import com.datahub.domain.CarOrder;
import com.datahub.mybatis.mapper.CarOrderMapper;
import com.datahub.web.dto.CarOrderDetailResult;
import com.datahub.web.dto.responseDto.CarOrderDetailDto;
import com.datahub.web.runtime.WebLoginUser;
import com.datahub.common.util.ConfigUtil;
import com.datahub.common.dto.response.CarOrderListResult;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.io.IOUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.math.BigDecimal;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Create by HuQiuYue on 2020/8/6
 */

public class CarOrderStepDef extends WebLoginStepDef {
    private static final Logger logger = LoggerFactory.getLogger(CarOrderStepDef.class);

    @Autowired private WebLoginUser loginUser;
    @Autowired private CarOrderMapper carOrderMapper;

    String startDate = new DateTime().toString(DateUtil.TIME_FORMAT_PATTERN);
    String endDate = new DateTime().minusDays(7).toString(DateUtil.TIME_FORMAT_PATTERN);


    //时间问题  还需要调试
    @Parameters({"entCode"})
    @Test(groups = {"web"})
    public void getCarOrderList(String entCode) throws Throwable{
        String body = IOUtils.toString(new FileInputStream(ConfigUtil.getTestDataPath() + "/Json/searchOrderParam.json"),"UTF-8");
        JSONObject json = (JSONObject) JSON.parse(body);
        json.put("startTime",startDate);
        json.put("endTime",endDate);

        System.out.println(json.toString());

        Response response = given().accept("application/json").contentType(ContentType.JSON)
                .header("entCode",entCode).header("tokenId",loginUser.getTokenId())
                .body(json.toString()).post(ConfigUtil.getWebBaseUrl() + Constant.CAR_ORDER_LIST_URL);

        CarOrderListResult result = response.getBody().as(CarOrderListResult.class);
        long actualOrderCount = result.getData().getTotal();
        long expectedOrderCount = carOrderMapper.getCarOrderCount(entCode,startDate,endDate,false);
        assertThat(actualOrderCount,equalTo(expectedOrderCount));
    }

    @Parameters({"entCode"})
    @Test(groups = {"web"})
    public void getCarOrderDetail(String entCode){
        logger.info("**********获取打车订单详情*************");

        String appCode = "didi";
        String operationId = "1125908338435803";
        org.json.JSONObject json = new org.json.JSONObject().put("appCode",appCode).put("operationId",operationId);

        Response response = given().accept("application/json").contentType(ContentType.JSON)
                .header("entCode",entCode).header("tokenId",loginUser.getTokenId())
                .body(json.toString()).post(ConfigUtil.getWebBaseUrl() + Constant.CAR_ORDER_DETAIL_URL);

        CarOrderDetailDto result = response.getBody().as(CarOrderDetailResult.class).getData();
        String actualPayType = result.getPayType();
        float actualTotalFee = result.getTotalFee();
        String actualPassengerName = result.getPassengerName();
        CarOrder carOrder = carOrderMapper.getCarOrder(entCode,operationId);
        String expectPayType = carOrder.getPayType();
        BigDecimal expectedTotalFee = carOrder.getTotalPrice();
        String passengers = carOrder.getPassenger();
        JSONObject passenger = JSONObject.parseObject(passengers);
        String expectPassengerName = (String) passenger.get("employeeName");

        assertThat(actualPassengerName,equalTo(expectPassengerName));
        assertThat(actualTotalFee,equalTo(expectedTotalFee.floatValue()));
        assertThat(actualPayType,equalTo(expectPayType));
    }

}
