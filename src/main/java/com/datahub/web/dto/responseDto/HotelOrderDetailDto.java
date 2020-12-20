package com.datahub.web.dto.responseDto;

import lombok.Data;

import java.util.List;

/**
 * Create by HuQiuYue on 20206
 */
@Data
public class HotelOrderDetailDto extends OrderMetadataDto {
    private float serviceFee;

    private float deductibleTaxFee;

    private float nonDeductibleTaxFee;

    private String hotelName;

    private String hotelAddress;

    private String hotelTel;

    private String cityCode;

    private String hotelCityCode;

    private String hotelCityName;

    private String roomName;

    private int roomQuantity;

    private int roomDayCount;

    private float roomPrice;

    private String checkinAt;

    private String checkoutAt;

    private boolean prePaid;
    private List<HotelClient> clients;
    private List<HotelRoom> hotelRooms;
}
