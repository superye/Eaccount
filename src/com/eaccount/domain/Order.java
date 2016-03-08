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
    private String user_phone_number;
    private String company_name;
    private String company_address;
    private String company_logo;
    private List<Order_detail> order_details;

    /**
     *
     */

    private String no_paid_order_number;
    private String no_paid_money;
    /*
    *  查询订单类别：已送 1，未送 2，全部 3
    * */
    private String type;

    /*
    * 凭据照片
    * */
    private String photo;

    public String getNo_paid_order_number() {
        return no_paid_order_number;
    }

    public void setNo_paid_order_number(String no_paid_order_number) {
        this.no_paid_order_number = no_paid_order_number;
    }

    public String getNo_paid_money() {
        return no_paid_money;
    }

    public void setNo_paid_money(String no_paid_money) {
        this.no_paid_money = no_paid_money;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getCompany_id_seller() {
        return company_id_seller;
    }

    public void setCompany_id_seller(String company_id_seller) {
        this.company_id_seller = company_id_seller;
    }

    public String getCompany_id_buyer() {
        return company_id_buyer;
    }

    public void setCompany_id_buyer(String company_id_buyer) {
        this.company_id_buyer = company_id_buyer;
    }

    public String getUser_id_seller() {
        return user_id_seller;
    }

    public void setUser_id_seller(String user_id_seller) {
        this.user_id_seller = user_id_seller;
    }

    public String getUser_id_buyer() {
        return user_id_buyer;
    }

    public void setUser_id_buyer(String user_id_buyer) {
        this.user_id_buyer = user_id_buyer;
    }

    public String getPlace_order_time() {
        return place_order_time;
    }

    public void setPlace_order_time(String place_order_time) {
        this.place_order_time = place_order_time;
    }

    public String getReceiving_time() {
        return receiving_time;
    }

    public void setReceiving_time(String receiving_time) {
        this.receiving_time = receiving_time;
    }

    public String getTotal_price_saller() {
        return total_price_saller;
    }

    public void setTotal_price_saller(String total_price_saller) {
        this.total_price_saller = total_price_saller;
    }

    public String getTotal_price_buyer() {
        return total_price_buyer;
    }

    public void setTotal_price_buyer(String total_price_buyer) {
        this.total_price_buyer = total_price_buyer;
    }

    public String getPaid_price() {
        return paid_price;
    }

    public void setPaid_price(String paid_price) {
        this.paid_price = paid_price;
    }

    public String getIs_reconciliation() {
        return is_reconciliation;
    }

    public void setIs_reconciliation(String is_reconciliation) {
        this.is_reconciliation = is_reconciliation;
    }

    public String getPayment_day() {
        return payment_day;
    }

    public void setPayment_day(String payment_day) {
        this.payment_day = payment_day;
    }

    public int getType_number() {
        return type_number;
    }

    public void setType_number(int type_number) {
        this.type_number = type_number;
    }

    public int getProduct_number() {
        return product_number;
    }

    public void setProduct_number(int product_number) {
        this.product_number = product_number;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_phone_number() {
        return user_phone_number;
    }

    public void setUser_phone_number(String user_phone_number) {
        this.user_phone_number = user_phone_number;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_address() {
        return company_address;
    }

    public void setCompany_address(String company_address) {
        this.company_address = company_address;
    }

    public String getCompany_logo() {
        return company_logo;
    }

    public void setCompany_logo(String company_logo) {
        this.company_logo = company_logo;
    }

    public List<Order_detail> getOrder_details() {
        return order_details;
    }

    public void setOrder_details(List<Order_detail> order_details) {
        this.order_details = order_details;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
