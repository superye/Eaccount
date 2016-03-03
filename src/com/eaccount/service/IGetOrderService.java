package com.eaccount.service;

import com.eaccount.domain.Order;

import java.util.List;

/**
 * Created by spzn on 16-3-3.
 */
public interface IGetOrderService {
    public List<Order> GetOrderByUserIdSeller(int id);
    public List<Order> GetOrderByUserIdBuyer(int id);

    public List<Order> GetOrderDetailByOrderId(int id);
}
