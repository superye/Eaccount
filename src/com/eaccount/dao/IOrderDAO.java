package com.eaccount.dao;

import com.eaccount.domain.Order;

import java.util.List;

/**
 * Created by spzn on 16-3-3.
 */
public interface IOrderDAO {
    public List<Order> SellerGetOrderMessageByUserId(Order order);
    public List<Order> SellerGetOrderMessageByOrderId(Order order);
    public boolean UpdateOrderSellerId(Order order);
}
