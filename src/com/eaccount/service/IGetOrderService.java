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

    public int GetCountMattrOrder(String user_id, String company_id, String type);
    public int GetCountPayment(String user_id, String company_id, String type);

    public List<Order> GetMatterOrderInfo(String user_id, String company_id, String type);
    public List<Order> GetMatterOrderDetailInfo(String user_id, String company_id, String type, String is_reconciliation);

    public List<Order_detail> GetOrderDetailByOrderId(String id);
    public List<Order_detail> GetOrderDetailByMatterOrderId(String id);

    public List<Order> GetNoPaidOrderByUserBuyerId(String id);
    public List<Order> GetNoPaidOrderByUserSellerId(String id);

    public List<Order> GetAccountPeriod(String user_id, String type);
    public int CountOverdueOrder(String user_id);
    public int CountNotSendOrReceivingOrder(String user_id, String type);
}
