package com.datahub.common.constant;

/**
 * Create by HuQiuYue on 2020/6/3
 */
public class Constant {
//    登录
    public static final String AUTH_LOGIN_URL = "/auth/login";

//      ***** 城市 *****
//    根据city_code获取城市信息
    public static final String GET_CITY_CODE_URL = "/reference-data/city";
//    调用方将使用该接口，完成城市映射
    public static final String GET_PATENT_CITY_CODE_URL = "/reference-data/city/sync";
//    根据调用方传来的参数，筛选出相对应的城市列表
    public static final String SEARCH_CITY_INFO_URL = "/reference-data/city/search";

//    ***** 部门 *****
//    查询企业某颗部门树
    public static final String DEPARTMENT_TREE_URL = "/department/tree";
//    查询单个部门信息
    public static final String DEPARTMENT_INFO_URL = "/department/detail";
//    查询企业所有部门信息
    public static final String SEARCH_ALL_DEPARTMENT_URL = "/department/all";
//    启用单个部门信息，所有的上级部门
    public static final String ENABLE_DEPARTMENT_URL = "/department/enable";
//    删除单个部门之后，部门下面的子部门会被上移到部门的上级部门
    public static final String DELETE_DEPARTMENT_URL = "/department/delete";
//    停用单个部门之后，部门下面的所有子部门会被同时停用
    public static final String DISABLE_DEPARTMENT_URL = "/department/disable";
//    新增/更新部门(批量)
    public static final String ADD_DEPARTMENT_URL = "/department/save";
//    新增/更新部门(批量)
    public static final String ADD_DEPARTMENT_PRINCIPAL_URL = "/department/principal/save";

//    ***** 子公司 *****
//    查询单个子公司信息
    public static final String SUBSIDIARY_INFO_URL = "/subsidiary/detail";
//    查询企业所有子公司信息
    public static final String SEARCH_ALL_SUBSIDIARY_URL = "/subsidiary/all";
//    查询子公司信息树
    public static final String SEARCH_SUBSIDIARY_TREE_URL = "/subsidiary/tree";
//    启用单个子公司信息，所有的上级公司必须是启用的
    public static final String ENABLE_SUBSIDIARY_URL = "/subsidiary/enable";
//    删除单个子公司之后，子公司下面的子树会被上移到子公司的上级公司
    public static final String DELETE_SUBSIDIARY_URL = "/subsidiary/delete";
//    停用单个子公司之后，子公司下面的子树会被同时停用
    public static final String DISABLE_SUBSIDIARY_URL = "/subsidiary/disable";
//    新增/更新子公司(批量)
    public static final String ADD_SUBSIDIARY_URL = "/subsidiary/save";
//    新增/更新子公司负责人(批量)
    public static final String ADD_SUBSIDIARY_PRINCIPLE_URL = "/subsidiary/principal/save";

//    ***** 职级 *****
//    查询单个职级信息
    public static final String RANK_INFO_URL = "/rank/detail";
//    查询企业所有职级信息
    public static final String SEARCH_ALL_RANK_URL = "/rank/all";
//    启用单个职级
    public static final String ENABLE_RANK_URL = "/rank/enable";
//    删除单个职级
    public static final String delete_RANK_URL = "/rank/delete";
//    停用单个职级
    public static final String DISABLE_RANK_URL = "/rank/disable";
//    新增/更新职级(批量)
    public static final String ADD_RANK_URL = "/rank/save";

//    ***** 职位 *****
//    查询单个职位信息
    public static final String POSITION_INFO_URL = "/position/detail";
//    查询企业所有职位信息
    public static final String SEARCH_ALL_POSITION_URL = "/position/all";
//    启用单个职位信息，所有的上级职位必须是启用的
    public static final String ENABLE_POSITION_URL = "/position/enable";
//    删除单个职位之后，职位下面的子职位会被上移到职位的上级职位
    public static final String DELETE_POSITION_URL = "/position/delete";
//    停用单个职位之后，职位下面的所有子职位会被同时停用
    public static final String DISABLE_POSITION_URL = "/position/disable";
//    新增/更新职位(批量)
    public static final String ADD_POSITION_URL = "/position/save";

//    ***** 员工 *****
//    新增／更新员工(批量)
    public static final String ADD_MEMBER_URL = "/employee/save";
//    新增／更新员工汇报关系(批量)
    public static final String ADD_MEMBER_REPORT_LINE_URL = "/employee/report-lines/save";


//    ***** 审批单 *****
//    推送火车票申请单
    public static final String SAVE_TRAIN_APPROVAL_URL = "/trip-approval/train/save";
//    推送机票申请单
    public static final String SAVE_FLIGHT_APPROVAL_URL = "/trip-approval/flight/save";
//    推送酒店申请单
    public static final String SAVE_HOTEL_APPROVAL_URL = "/trip-approval/hotel/save";
//    推送用车申请单
    public static final String SAVE_CAR_APPROVAL_URL = "/trip-approval/car/save";
//    推送审批单自定义配置项
    public static final String SAVE_CUSTOM_APPROVAL_URL = "/trip-approval/custom-field-setting/save";


//    ***** 订单列表及详情 *****
//    订单报销状态更新
    public static final String UPDATE_ORDER_REIMBURSE_STATUS_URL = "/order/reimburse";
//    查询用车订单列表
    public static final String CAR_LIST_URL = "/order/car/list";
//    查询用车订单详情
    public static final String CAR_DETAIL_URL = "/order/car/detail";

//    ***** 对账 *****


//    ***** 员工绑定 *****
//    查询员工所有应用绑定详情及所属企业开通状态
    public static final String EMPLOYEE_BOUND_INFO_URL = "/employee/bound-details";
//    员工绑定应用账号
    public static final String SEARCH_EMPLOYEE_BOUND_APP_ACCOUNT_URL = "/employee/bind-to-app";



    //    ***** web端 *****

//    ***** 开票接口 *****

//    申请开票
    public static final String APPLY_INVOICE_URL = "/invoice/{appCode}/apply";
//    获取发票下载地址
    public static final String GET_INVOICE_DOWNLOAD_URL = "/invoice/{appCode}/export/url";
//    通过Id导出订单
    public static final String EXPORT_ORDER_BY_ID_URL = "/invoice/{appCode}/order/exportById";
//    批量导出发票
    public static final String EXPORT_BATCH_INVOICE_URL = "/invoice/{appCode}/order/exportById";
//    查询打车订单列表
    public static final String SEARCH_CAR_ORDER_LIST_URL = "/invoice/{appCode}/orderList";
//    查询发票列表
    public static final String SEARCH_INVOICE_URL = "/invoice/{appCode}/search";
//    获取开票发票详情
    public static final String GET_INVOICE_INFO_LIST_URL = "/invoice/apply-invoice-info/list";
//    获取发票开票历史excel
    public static final String GET_INVOICE_EXCEL_URL = "/invoice/excel/download";

//    init接口
    public static final String WEB_INIT_URL = "/init";

//    机票订单接口
    public static final String FLIGHT_ORDER_LIST_URL = "/order/flight/list";
//    机票订单详情接口
    public static final String FLIGHT_ORDER_DETAIL_URL = "/order/flight/detail";
//    酒店订单接口
    public static final String HOTEL_ORDER_LIST_URL = "/order/hotel/list";
//    酒店订单详情接口
    public static final String HOTEL_ORDER_DETAIL_URL = "/order/hotel/detail";
//    火车订单接口
    public static final String TRAIN_ORDER_LIST_URL = "/order/train/list";
//    火车订单详情接口
    public static final String TRAIN_ORDER_DETAIL_URL = "/order/train/detail";
//    打车订单接口
    public static final String CAR_ORDER_LIST_URL = "/order/car/list";
//    打车订单详情接口
    public static final String CAR_ORDER_DETAIL_URL = "/order/car/detail";
//    餐饮订单接口
    public static final String MEAL_ORDER_LIST_URL = "/order/meal/list";
//    餐饮订单接口
    public static final String MEAL_DETAIL_LIST_URL = "/order/meal/detail";

//    企业详情接口
    public static final String ENTERPRISE_DETAIL_URL = "/enterprise/details";
//    部门详情接口
    public static final String DEPARTMENT_DETAIL_URL = "/department/children";
//    搜索部门信息
    public static final String SEARCH_DEPARTMENT_INFO_URL = "/department/search";

//    员工列表
    public static final String EMPLOYEE_LIST_URL = "/employee/search";
//    查看员工详情
    public static final String EMPLOYEE_DETAIL_URL = "/employee/detail";
//    保存员工信息
    public static final String SAVE_EMPLOYEE_URL = "/employee/modify";
//    更新员工权限
    public static final String UPDATE_EMPLOYEE_ROLE_URL = "/employee/role";
//    获取员工绑定详情
    public static final String EMPLOYEE_SYNC_INFO_URL = "/employee/all-sync-info";


//    职级
    public static final String ALL_RANK_INFO_URL = "/rank/all";
//    全部职位
    public static final String ALL_POSITION_INFO_URL = "/position/children";
//    职位搜索
    public static final String POSITION_SEARCH_BY_KEYWORD_URL = "/position/search";
//    获取全部角色
    public static final String GET_ALL_ROLE_URL = "/role/ent-all";
//    获取某个角色详情
    public static final String GET_ROLE_DETAIL_URL = "/role/detail";
}


