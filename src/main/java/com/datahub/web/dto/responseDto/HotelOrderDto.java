package com.datahub.web.dto.responseDto;

import lombok.Data;

import java.util.List;

/**
 * Create by HuQiuYue on 2020/8/4
 */
@Data
public class HotelOrderDto extends OrderMeta {

    private String checkinAt;
    private String checkoutAt;

    private float roomPrice;
    private float serviceFee;
    private float extraServiceFee;
    private int roomQuantity;
    private int roomDayCount;

    private String roomName;
    private String hotelName;
    private String hotelAddress;
    private String hotelTel;
    private String hotelCityName;
    private String cityCodePFC;

    private List<HotelClient> clients;
    private List<HotelRoom> hotelRooms;
}
