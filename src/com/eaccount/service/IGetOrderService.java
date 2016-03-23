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
    public List<Order> GetOrderByOrderId(String id, String type);
    public List<Order> GetOrderByUserIdBuyer(int id);

    public int GetCountMattrOrder(String company_id1, String company_id2, String type);
    public int GetCountPayment(String user_id, String company_id2, String type);

    public List<Order> GetMatterOrderInfo(String company_id1, String company_id2, String type);
    public List<Order> GetMatterOrderDetailInfo(String company_id1, String company_id2, String type, String is_reconciliation);

    public List<Order_detail> GetOrderDetailByOrderId(String id);
    public List<Order_detail> GetOrderDetailByMatterOrderId(String id);

    public List<Order> GetNoPaidOrderByUserBuyerId(String id);
    public List<Order> GetNoPaidOrderByUserSellerId(String id);

    /**
     * 获得已对账未付款订单
     * @param id
     * @return
     */
    public List<Order> GetRecNoPaidOrderByUserBuyerId(String id);
    public List<Order> GetRecNoPaidOrderByUserSellerId(String id);


    public List<Order> GetAccountPeriod(String user_id, String type);
    public int CountOverdueOrder(String user_id);
    public int CountNotSendOrReceivingOrder(String user_id, String type);

    public String GetNewestOrderId();
    public String GetOrderIdByOrderDetailId(String id);
    public List<Order> GetOrderInfoByPayInfo(String company_id_seller, String company_id_buyer);
}
