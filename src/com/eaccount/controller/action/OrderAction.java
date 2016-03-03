package com.eaccount.controller.action;

import com.eaccount.domain.Order;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSONObject;

/**
 * Created by spzn on 16-3-3.
 */
public class OrderAction extends SuperAction implements ModelDriven<Order>{
    Order order = new Order();

    public String GetOrderMessage() {
        JSONObject jsonObject = new JSONObject();
        return "GetOrderMessage";
    }

    @Override
    public Order getModel() {
        return order;
    }
}
