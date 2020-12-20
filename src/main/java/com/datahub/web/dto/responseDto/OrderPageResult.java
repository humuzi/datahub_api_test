package com.datahub.web.dto.responseDto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Create by HuQiuYue on 2020/7/24
 */
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderPageResult<T extends OrderMeta> {
    private List<T> records;
    private long total;
    private boolean hasNextPage;



}
