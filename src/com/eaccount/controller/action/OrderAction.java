package com.eaccount.controller.action;

import com.eaccount.domain.Order;
import com.eaccount.service.GetOrderService;
import com.eaccount.service.IGetOrderService;
import com.opensymphony.xwork2.ModelDriven;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by spzn on 16-3-3.
 */
public class OrderAction extends SuperAction implements ModelDriven<Order>{
    Order order = new Order();

    public String GetOrderMessage() {
        List<Order> list = new ArrayList<>();
        IGetOrderService getOrderService = new GetOrderService();
        String id = order.getUser_id_seller();
        String type = order.getType();
        list = getOrderService.GetOrderByUserIdSeller(id, type);
        System.out.println(list.get(0).getCompany_name());
        System.out.println(list.get(0).getType_number());
        System.out.println(list.get(0).getProduct_number());
        return "GetOrderMessage";
    }

    @Override
    public Order getModel() {
        return order;
    }
}
