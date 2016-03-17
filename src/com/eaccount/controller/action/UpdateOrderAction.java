package com.eaccount.controller.action;

import com.eaccount.domain.Order;
import com.eaccount.util.GetNowTime;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Created by yehao on 16/3/17.
 */
public class UpdateOrderAction extends SuperAction implements ModelDriven<Order>{
    Order order = new Order();

    public void InsertOrder() {
        GetNowTime getNowTime = new GetNowTime();
        Order order = new Order();

        String order_id = request.getParameter("order_id");
        String company_id_seller = request.getParameter("company_id_seller");
        String company_id_buyer;
        String user_id_seller = request.getParameter("user_id_seller");
        String user_id_buyer;
        String place_order_time = getNowTime.GetTime(1);
        String receiving_time;
        String total_price_seller = request.getParameter("total_price_seller");
        String total_price_buyer;
        String paid_price;
        String is_reconciliation;
        String payment_day = request.getParameter("payment_day");

        order.setOrder_id(order_id);
        order.setCompany_id_seller(company_id_seller);
        order.setPlace_order_time(place_order_time);
        order.setUser_id_seller(user_id_seller);
        order.setTotal_price_seller(total_price_seller);
        order.setPayment_day(payment_day);


    }

    @Override
    public Order getModel() {
        return order;
    }
}
