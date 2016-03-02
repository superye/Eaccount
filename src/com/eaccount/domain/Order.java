package com.eaccount.domain;

import java.util.List;

/**
 * Created by yehao on 16/3/1.
 */
public class Order {
    private String id;
    private String order_id;
    private String company_id_seller;
    private String company_id_buyer;
    private String user_id_seller;
    private String user_id_buyer;
    private String place_order_time;
    private String receiving_time;
    private String total_price_saller;
    private String total_price_buyer;
    private String paid_price;
    private String is_reconciliation;
    private String payment_day;

    /**
     * 额外补充属性
     *
     * 商品种类.商品总数(用于返回订单基本信息)
     */
    private int type_number;
    private int product_number;

    /**
     *
     * 收货人姓名,收货人手机号,公司名字,公司地址,公司logo,详情列表(用于返回订单详情)
     *
     */
    private String user_name;
    private String user_phone;
    private String company_name;
    private String company_address;
    private String company_logo;
    private List<Order_detail> order_details;

}
