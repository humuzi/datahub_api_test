package com.datahub.web.steps;

import com.datahub.common.constant.Constant;
import com.datahub.common.util.DateUtil;
import com.datahub.web.runtime.WebLoginUser;
import com.datahub.common.util.ConfigUtil;
import com.datahub.domain.FlightTicket;
import com.datahub.mybatis.mapper.FlightOrderMapper;
import com.datahub.mybatis.mapper.FlightTicketMapper;
import com.datahub.web.dto.FlightOrderDetailResult;
import com.datahub.common.dto.response.FlightOrderListResult;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.joda.time.DateTime;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Create by HuQiuYue on 2020/7/24
 */


public class FlightOrderStepDef extends WebLoginStepDef {

    private static final Logger logger = LoggerFactory.getLogger(FlightOrderStepDef.class);

    @Autowired private WebLoginUser loginUser;
    @Autowired private FlightOrderMapper flightOrderMapper;
    @Autowired private FlightTicketMapper flightTicketMapper;

    String startDate = new DateTime().toString(DateUtil.TIME_FORMAT_PATTERN);
    String endDate = new DateTime().minusDays(7).toString(DateUtil.TIME_FORMAT_PATTERN);

    @Parameters({"entCode"})
    @Test(groups = {"web"})
    public void getFlightOrderList(String entCode){

        logger.info("*********获取机票列表信息*************");

        JSONObject body = new JSONObject().put("startTime",startDate).put("endTime",endDate).put("keyword","").put("pageNo",1).put("pageSize",20);
        Response response = given().accept("application/json").contentType(ContentType.JSON)
                .header("entCode",entCode).header("tokenId",loginUser.getTokenId())
                .body(body.toString()).post(ConfigUtil.getWebBaseUrl() + Constant.FLIGHT_ORDER_LIST_URL);

        FlightOrderListResult result = response.getBody().as(FlightOrderListResult.class);
        Long actualFlightOrderCount = (Long) result.getData().getTotal();
        Long expectFlightOrderCount = flightOrderMapper.getFlightCount(entCode,startDate,endDate,true);

        assertThat(response.getStatusCode(),equalTo(200));
        assertThat(actualFlightOrderCount,equalTo(expectFlightOrderCount));

    }


     @Parameters({"entCode"})
    @Test(groups = {"web"})
    public void getFlightOrderDetail(String entCode) {

        logger.info("*********获取机票详情************");

        JSONObject body = new JSONObject().put("appCode", "flyby").put("operationId", "130929921671311");
        Response response = given().accept("application/json").contentType(ContentType.JSON)
                .header("entCode", entCode).header("tokenId", loginUser.getTokenId())
                .body(body.toString()).post(ConfigUtil.getWebBaseUrl() + Constant.FLIGHT_ORDER_DETAIL_URL);

        FlightOrderDetailResult result = response.getBody().as(FlightOrderDetailResult.class);
        String actualTicketNo = result.getData().getTickets().get(0).getTicketNo();
        Float actualTotalPayFee = result.getData().getTickets().get(0).getTotalPayFee();
        String actualPassengerName = result.getData().getTickets().get(0).getPassengerName();

        FlightTicket ticket  = flightTicketMapper.getFlightTicket(entCode,"flyby","130929921671311");
        String expectedTicketNo = ticket.getTicketNo();
        BigDecimal expectedTotalPayFee = ticket.getTicketFee().add(ticket.getInsuranceFee()).add(ticket.getTicketServiceFee()).add(ticket.getTaxFee()).add(ticket.getOilFee());
        String expectedPassenger = ticket.getPassenger();
        com.alibaba.fastjson.JSONObject passenger = com.alibaba.fastjson.JSONObject.parseObject(expectedPassenger);
        String expectedPassengerName = (String) passenger.get("externalEmployeeName");

        assertThat(actualTicketNo,equalTo(expectedTicketNo));
        assertThat(actualTotalPayFee,equalTo(expectedTotalPayFee.floatValue()));
        assertThat(actualPassengerName,equalTo(expectedPassengerName));
    }
}