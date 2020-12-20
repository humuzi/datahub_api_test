package com.datahub.web.dto.responseDto;

import com.github.pagehelper.PageSerializable;

/**
 * Create by HuQiuYue on 2020/9/9
 */
public class PageInfo<T> extends PageSerializable<T> {
    private int pageNum;
    private int pageSize;
    private int size;
    private int startRow;
    private int endRow;
    private int pages;
    private int prePage;
    private int nextPage;
    private boolean isFirstPage;
    private boolean isLastPage;
    private boolean hasPreviousPage;
    private boolean hasNextPage;
    private int navigatePages;
    private int[] navigatepageNums;
    private int navigateFirstPage;
    private int navigateLastPage;
}
