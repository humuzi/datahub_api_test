package com.datahub.web.steps;

import com.alibaba.fastjson.JSON;
import com.datahub.domain.TrainOrder;
import org.joda.time.DateTime;
import org.json.JSONObject;
import com.datahub.common.constant.Constant;
import com.datahub.common.util.DateUtil;
import com.datahub.web.runtime.WebLoginUser;
import com.datahub.common.util.ConfigUtil;
import com.datahub.domain.TrainTicket;
import com.datahub.mybatis.mapper.TrainOrderMapper;
import com.datahub.mybatis.mapper.TrainTicketMapper;
import com.datahub.web.dto.TrainOrderDetailResult;
import com.datahub.common.dto.response.TrainOrderListResult;
import com.datahub.web.dto.responseDto.OrderPageResult;
import com.datahub.web.dto.responseDto.TrainOrderDetailDto;
import com.datahub.web.dto.responseDto.TrainOrderDto;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Create by HuQiuYue on 2020/8/13
 */

public class TrainOrderStepDef extends WebLoginStepDef {
    private static final Logger logger = LoggerFactory.getLogger(TrainOrderStepDef.class);

    @Autowired private WebLoginUser loginUser;
    @Autowired private TrainOrderMapper trainOrderMapper;
    @Autowired private TrainTicketMapper trainTicketMapper;

    @Parameters({"entCode"})
    @Test(groups = {"web"})
    public void getTrainOrderList(String entCode) throws Throwable{
        String startDate = new DateTime().toString(DateUtil.TIME_FORMAT_PATTERN);
        String endDate = new DateTime().minusDays(7).toString(DateUtil.TIME_FORMAT_PATTERN);
        String body = IOUtils.toString(new FileInputStream(ConfigUtil.getTestDataPath() + "/Json/searchOrderParam.json"),"UTF-8");
        com.alibaba.fastjson.JSONObject json = (com.alibaba.fastjson.JSONObject) JSON.parse(body);
        json.put("startTime",startDate);
        json.put("endTime",endDate);

        Response response = given().accept("application/json").contentType(ContentType.JSON)
                .header("entCode", entCode).header("tokenId", loginUser.getTokenId())
                .body(json.toString()).post(ConfigUtil.getWebBaseUrl() + Constant.TRAIN_ORDER_LIST_URL);

        OrderPageResult<TrainOrderDto> result = response.getBody().as(TrainOrderListResult.class).getData();
        long actualTrainOrderCount = result.getTotal();
        long expectTrainOrderCount = trainOrderMapper.getTrainOrderCount(entCode,startDate,endDate,false);
        assertThat(response.getStatusCode(),equalTo(200));
        assertThat(actualTrainOrderCount,equalTo(expectTrainOrderCount));
    }

    @Parameters({"entCode"})
    @Test(groups = {"web"})
    public void getTrainOrderDetail(String entCode){
        logger.info("***********获取火车票详情*************");

        String appCode = "ctrip";
        String operationId = "13531139029";
        JSONObject json = new JSONObject().put("appCode",appCode).put("operationId",operationId);

        Response response = given().accept("application/json").contentType(ContentType.JSON)
                .header("entCode",entCode).header("tokenId",loginUser.getTokenId())
                .body(json.toString()).post(ConfigUtil.getWebBaseUrl() + Constant.TRAIN_ORDER_DETAIL_URL);

        TrainOrderDetailDto result = response.getBody().as(TrainOrderDetailResult.class).getData();
        String actualPayType= result.getPayType();
        float actualTotalFee = result.getTotalFee();
        List<String> actualPassenger = new ArrayList<>();
        if(result.getTickets() != null){
            for(int i=0;i <result.getTickets().size();i++){
                String passenger = result.getTickets().get(i).getPassengerName();
                if(passenger != null){
                    actualPassenger.add(passenger);
                }
            }
        }

        TrainOrder trainOrder = trainOrderMapper.getTrainOrderList(entCode,operationId);
        String expectPayType = trainOrder.getPayType();
        List<TrainTicket> trainTicket = trainTicketMapper.getTrainOrderDetail(entCode,operationId);
        List<BigDecimal> expectTotalPayFee = new ArrayList<>();
        List<String> expectPassengerName = new ArrayList<>();
        for(int i =0;i<trainTicket.size();i++){
            BigDecimal totalPayFee = trainTicket.get(i).getTicketFee().add(trainTicket.get(i).getInsuranceFee()).add(trainTicket.get(i).getTicketServiceFee());
            String passenger= trainTicket.get(i).getPassenger();
            com.alibaba.fastjson.JSONObject passengerName = com.alibaba.fastjson.JSONObject.parseObject(passenger);
            String name = (String) passengerName.get("externalEmployeeName");
            expectTotalPayFee.add(totalPayFee);
            expectPassengerName.add(name);
        }

        assertThat(actualPayType,equalTo(expectPayType));
        assertThat(actualPassenger,equalTo(expectPassengerName));

        logger.info("测试通过");

    }
}
