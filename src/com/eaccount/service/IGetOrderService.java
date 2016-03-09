package com.eaccount.service;

import com.eaccount.domain.Order;
import com.eaccount.domain.Order_detail;

import java.util.List;

/**
 * Created by spzn on 16-3-3.
 */
public interface IGetOrderService {
    public List<Order> GetOrderByUserIdSeller(String id, String type);
    public List<Order> GetOrderByUserIdBuyer(String id, String type);
    public List<Order> GetOrderByOrderId(String id);
    public List<Order> GetOrderByUserIdBuyer(int id);

    public List<Order_detail> GetOrderDetailByOrderId(String id);
    public List<Order> GetNoPaidOrderByUserBuyerId(String id);
    public List<Order> GetNoPaidOrderByUserSellerId(String id);

    public List<Order> GetPayListByUserBuyerId(String userId, String companyId);

}
