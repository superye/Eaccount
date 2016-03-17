package com.eaccount.service;

import com.eaccount.domain.Order;

/**
 * Created by spzn on 16-3-6.
 */
public interface IUpdateOrderService {
    public boolean UpdateOrderSellerId(String order_id, String user_id, String type);
    public boolean InsertOrder(Order order);
}
