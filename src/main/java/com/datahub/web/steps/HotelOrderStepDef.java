package com.datahub.web.steps;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.datahub.common.constant.Constant;
import com.datahub.common.util.DateUtil;
import com.datahub.web.runtime.WebLoginUser;
import com.datahub.common.util.ConfigUtil;
import com.datahub.domain.HotelOrder;
import com.datahub.mybatis.mapper.HotelOrderMapper;
import com.datahub.web.dto.HotelOrderDetailResult;
import com.datahub.common.dto.response.HotelOrderListResult;
import com.datahub.web.dto.responseDto.HotelOrderDetailDto;
import com.datahub.web.dto.responseDto.OrderPageResult;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.io.IOUtils;
import org.joda.time.DateTime;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.Arrays;


import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

/**
 * Create by HuQiuYue on 2020/7/30
 */
public class HotelOrderStepDef extends WebLoginStepDef {

    private static final Logger logger = LoggerFactory.getLogger(HotelOrderStepDef.class);

    @Autowired private WebLoginUser loginUser;
    @Autowired private HotelOrderMapper hotelOrderMapper;

    String startDate = new DateTime().toString(DateUtil.TIME_FORMAT_PATTERN);
    String endDate = new DateTime().minusDays(7).toString(DateUtil.TIME_FORMAT_PATTERN);

    @Parameters({"entCode"})
    @Test(groups = {"web"})
    public void getHotelList(String entCode) throws Throwable{

        logger.info("********获取全部订单列表***********");

        String body = IOUtils.toString(new FileInputStream(ConfigUtil.getTestDataPath() + "/Json/searchOrderParam.json"),"UTF-8");
        com.alibaba.fastjson.JSONObject json = (com.alibaba.fastjson.JSONObject) JSON.parse(body);
        json.put("startTime", startDate);
        json.put("endTime",endDate);

        Response response = given().accept("application/json").contentType(ContentType.JSON)
                .header("entCode", entCode).header("tokenId", loginUser.getTokenId())
                .body(json.toString()).post(ConfigUtil.getWebBaseUrl() + Constant.HOTEL_ORDER_LIST_URL);

        OrderPageResult result = response.getBody().as(HotelOrderListResult.class).getData();
        long actualOrderCount = result.getTotal();
        long expectedOrderCount = hotelOrderMapper.getHotelOrderCount(entCode,startDate,endDate,false);

        try{
            assertThat(response.getStatusCode(),equalTo(200));
            assertThat(actualOrderCount,equalTo(expectedOrderCount));
            logger.info("测试通过");
        }catch (Exception e){
            e.getMessage();
        }
    }

    @Parameters({"entCode"})
    @Test(groups = {"web"})
    public void getHotelListByKeywords(String entCode) throws Throwable{
        logger.info("********关键字搜索酒店订单***********");

        String body = IOUtils.toString(new FileInputStream(ConfigUtil.getTestDataPath() + "/Json/searchOrderParam.json"),"UTF-8");
        com.alibaba.fastjson.JSONObject json = (com.alibaba.fastjson.JSONObject) JSON.parse(body);
        json.put("keyword","胡");
        json.put("startTime",startDate);
        json.put("startTime",endDate);
        json.put("payTypes", Arrays.asList("CORP_ACCOUNT_PAY"));

        Response response = given().accept("application/json").contentType(ContentType.JSON)
                .header("entCode", entCode).header("tokenId", loginUser.getTokenId())
                .body(json.toString()).post(ConfigUtil.getWebBaseUrl() + Constant.HOTEL_ORDER_LIST_URL);

        OrderPageResult result = response.getBody().as(HotelOrderListResult.class).getData();
        long actualOrderCountByKeywords = result.getTotal();
        long expectedOrderCountByKeywords = hotelOrderMapper.getHotelOrderByKeyword(entCode,startDate,entCode,json.get("keyword").toString(),"CORP_ACCOUNT_PAY");

        assertThat(response.statusCode(),equalTo(200));
        assertThat(actualOrderCountByKeywords,equalTo(expectedOrderCountByKeywords));
        logger.info("测试通过");

    }

    //待完善

    @Parameters({"entCode"})
    @Test(groups = {"web"})
    public void getHotelOrderDetail(String entCode){
        logger.info("**********获取酒店订单详情***********");

        String appCode = "ctrip";
        String operationId = "13464094113";
        JSONObject body = new JSONObject().put("appCode",appCode).put("operationId",operationId);

        Response response = given().accept("application/json").contentType(ContentType.JSON)
                .header("entCode",entCode).header("tokenId",loginUser.getTokenId())
                .body(body.toString()).post(ConfigUtil.getWebBaseUrl() + Constant.HOTEL_ORDER_DETAIL_URL);

        System.out.println(response.getBody());
        HotelOrderDetailDto result = response.getBody().as(HotelOrderDetailResult.class).getData();
        String actualEmployeeName = result.getEmployeeName();
        float actualTotalFee = result.getTotalFee();
        String actualHotelName = result.getHotelName();
        String actualClientName = result.getClients().get(0).getClientName();
        HotelOrder hotelOrder = hotelOrderMapper.getHotelOrder(entCode,appCode,operationId);
        String expectedEmployeeName = hotelOrder.getEmployeeName();
        BigDecimal expectedTotalFee = hotelOrder.getTotalFee();
        String expectedHotelName = hotelOrder.getHotelName();
        JSONArray jsonArray = com.alibaba.fastjson.JSONObject.parseArray(hotelOrder.getClients());
        String expectedClientName  = null;

//        遍历方式一
        for(int i = 0;i< jsonArray.size();i++){
            com.alibaba.fastjson.JSONObject jsonObject = jsonArray.getJSONObject(i);
            String clientName = jsonObject.getString("externalEmployeeName");
            expectedClientName = clientName;
        }


//        遍历方式二
//        for(Object obj:jsonArray){
//            com.alibaba.fastjson.JSONObject json = (com.alibaba.fastjson.JSONObject) obj;
//            String clientName = json.getString("externalEmployeeName");
//            expectedClientName = clientName;
//        }

        assertThat(actualEmployeeName,equalTo(expectedEmployeeName));
        assertThat(actualTotalFee,equalTo(expectedTotalFee.floatValue()));
        assertThat(actualHotelName,equalTo(expectedHotelName));
        assertThat(actualClientName,equalTo(expectedClientName));

        logger.info("测试通过");
    }

}

