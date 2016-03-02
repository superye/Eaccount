package com.eaccount.service;

import com.eaccount.domain.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yehao on 16/3/2.
 */
public interface GetOrderService {
    public List<Order> GetOrderByUserIdSeller(int id);
    public List<Order> GetOrderByUserIdBuyer(int id);

    public List<Order> GetOrderDetailByOrderId(int id);
}
