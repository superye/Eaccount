package com.eaccount.controller.action;

import com.eaccount.domain.Order;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Created by spzn on 16-3-3.
 */
public class OrderAction extends SuperAction implements ModelDriven<Order>{
    Order order = new Order();

    public String GetOrderMessage() {

        return "GetOrderMessage";
    }

    @Override
    public Order getModel() {
        return order;
    }
}
