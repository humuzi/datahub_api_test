package com.datahub.platform.steps;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.datahub.common.constant.Constant;
import com.datahub.common.dto.resDto.MealOrderDto;
import com.datahub.common.dto.response.*;
import com.datahub.common.runtime.PlatformLoginUser;
import com.datahub.common.util.ConfigUtil;
import com.datahub.common.util.DateUtil;
import com.datahub.mybatis.mapper.*;
import com.datahub.web.dto.responseDto.*;
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
import java.util.Date;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Create by HuQiuYue on 2020/11/16
 */
public class OrderDefStep extends AuthLoginStepDef {
    private static final Logger logger = LoggerFactory.getLogger(OrderDefStep.class);

    @Autowired private PlatformLoginUser loginUser;
    @Autowired private FlightOrderMapper flightOrderMapper;
    @Autowired private HotelOrderMapper hotelOrderMapper;
    @Autowired private TrainOrderMapper trainOrderMapper;
    @Autowired private CarOrderMapper carOrderMapper;
    @Autowired private MealOrderMapper mealOrderMapper;


    String startDate = new DateTime().toString(DateUtil.TIME_FORMAT_PATTERN);
    String endDate = new DateTime().minusDays(7).toString(DateUtil.TIME_FORMAT_PATTERN);

    @Parameters({"entCode"})
    @Test(groups = {"platform"})
    public void getFlightOrder(String entCode) throws Throwable{
        logger.info("***************获取机票订单列表**************");
        String param = IOUtils.toString(new FileInputStream(ConfigUtil.getTestDataPath() + "/Json/platformOrderParam.json"),"UTF-8");
        JSONObject json = (JSONObject) JSON.parse(param);
        json.put("startTime",startDate);
        json.put("endTime",endDate);
        Response response = given().accept("application/json").contentType(ContentType.JSON)
                .header("entCode",entCode)
                .header("tokenId",loginUser.getTokenId())
                .body(json.toString()).post(ConfigUtil.getPlatformBaseUrl() + Constant.FLIGHT_ORDER_LIST_URL);


        OrderPageResult<FlightOrderDto> flightResult = response.getBody().as(FlightOrderListResult.class).getData();
        Long actualTotal = flightResult.getTotal();
        Long expectedTotal = flightOrderMapper.getFlightCount(entCode,startDate,endDate,true);
        logger.info("Actual order count is " + actualTotal + ",and expected order count is " + expectedTotal);

        assertThat(actualTotal,equalTo(expectedTotal));
    }

    @Parameters({"entCode"})
    @Test(groups = {"platform"})
    public void getHotelOrder(String entCode) throws Throwable{
        logger.info("***************获取酒店订单列表**************");
        String param = IOUtils.toString(new FileInputStream(ConfigUtil.getTestDataPath() + "/Json/platformOrderParam.json"),"UTF-8");
        JSONObject json = (JSONObject) JSON.parse(param);
        json.put("startTime",startDate);
        json.put("endTime",endDate);
        Response response = given().accept("application/json").contentType(ContentType.JSON)
                .header("entCode",entCode)
                .header("tokenId",loginUser.getTokenId())
                .body(json.toString()).post(ConfigUtil.getPlatformBaseUrl() + Constant.HOTEL_ORDER_LIST_URL);

        OrderPageResult<HotelOrderDto> hotelResult = response.getBody().as(HotelOrderListResult.class).getData();
        Long actualTotal = hotelResult.getTotal();
        Long expectedTotal = hotelOrderMapper.getHotelOrderCount(entCode,startDate,endDate,true);
        logger.info("Actual order count is " + actualTotal + ",and expected order count is " + expectedTotal);
        assertThat(expectedTotal,equalTo(actualTotal));
    }

    @Parameters({"entCode"})
    @Test(groups = {"platform"})
    public void getTrainOrder(String entCode) throws Throwable{
        logger.info("***************获取火车票订单列表**************");
        String param = IOUtils.toString(new FileInputStream(ConfigUtil.getTestDataPath() + "/Json/platformOrderParam.json"),"UTF-8");
        JSONObject json = (JSONObject) JSON.parse(param);
        json.put("startTime",startDate);
        json.put("endTime",endDate);
        Response response = given().accept("application/json").contentType(ContentType.JSON)
                .header("entCode",entCode)
                .header("tokenId",loginUser.getTokenId())
                .body(json.toString()).post(ConfigUtil.getPlatformBaseUrl() + Constant.TRAIN_ORDER_LIST_URL);

        OrderPageResult<TrainOrderDto> trainResult = response.getBody().as(TrainOrderListResult.class).getData();
        Long actualTotal = trainResult.getTotal();
        Long expectedTotal = trainOrderMapper.getTrainOrderCount(entCode,startDate,endDate,true);
        logger.info("Actual order count is " + actualTotal + ",and expected order count is " + expectedTotal);
        assertThat(actualTotal,equalTo(expectedTotal));
    }

    @Parameters({"entCode"})
    @Test(groups = {"platform"})
    public void getCarOrder(String entCode) throws Throwable{
        logger.info("***************获取打车订单列表**************");
        String param = IOUtils.toString(new FileInputStream(ConfigUtil.getTestDataPath() + "/Json/platformOrderParam.json"),"UTF-8");
        JSONObject json = (JSONObject) JSON.parse(param);
        json.put("startTime",startDate);
        json.put("endTime",endDate);
        Response response = given().accept("application/json").contentType(ContentType.JSON)
                .header("entCode",entCode)
                .header("tokenId",loginUser.getTokenId())
                .body(json.toString()).post(ConfigUtil.getPlatformBaseUrl() + Constant.CAR_ORDER_LIST_URL);

        OrderPageResult<CarOrderListDto> carResult = response.getBody().as(CarOrderListResult.class).getData();
        Long actualTotal = carResult.getTotal();
        Long expectedTotal = carOrderMapper.getCarOrderCount(entCode,startDate,endDate,true);
        logger.info("Actual order count is " + actualTotal + ",and expected order count is " + expectedTotal);
        assertThat(actualTotal,equalTo(expectedTotal));
    }

    @Parameters({"entCode"})
    @Test(groups = {"platform"})
    public void getMealOrder(String entCode) throws Throwable{
        logger.info("***************获取餐饮订单列表**************");

        String param = IOUtils.toString(new FileInputStream(ConfigUtil.getTestDataPath() + "/Json/platformOrderParam.json"),"UTF-8");
        JSONObject json = (JSONObject) JSON.parse(param);
        json.put("startTime",startDate);
        json.put("endTime",endDate);
        Response response = given().accept("application/json").contentType(ContentType.JSON)
                .header("entCode",entCode)
                .header("tokenId",loginUser.getTokenId())
                .body(json.toString()).post(ConfigUtil.getPlatformBaseUrl() + Constant.MEAL_ORDER_LIST_URL);

        OrderPageResult<MealOrderDto> carResult = response.getBody().as(MealOrderListResult.class).getData();
        Long actualTotal = carResult.getTotal();
        Long expectedTotal = mealOrderMapper.getMealOrderCount(entCode,startDate,endDate,true);
        logger.info("Actual order count is " + actualTotal + ",and expected order count is " + expectedTotal);
        assertThat(actualTotal,equalTo(expectedTotal));
    }
    
}
