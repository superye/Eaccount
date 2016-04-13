package com.eaccount.dao;

import com.eaccount.domain.Order;

import java.util.List;

/**
 * Created by spzn on 16-3-3.
 */
public interface IOrderDAO {
    public List<Order> SellerGetOrderMessageByUserId(Order order);
    public List<Order> BuyerGetOrderMessageByUserId(Order order);

    public List<Order> SellerGetOrderMessageByOrderId(Order order);
    public List<Order> BuyerGetOrderMessageByOrderId(Order order);

    public boolean UpdateOrderSellerId(Order order);
    public boolean UpdateOrderBuyerId(Order order);

    public boolean DeleteOrderInfoByOrderId(Order order);

    public int GetCountMatterOrder(Order order);
    public int GetCountPayment(Order order);

    public List<Order> GetMatterOrderInfo(Order order);
    public List<Order> GetMatterOrderDetailInfo(Order order);

    public List<Order> GetNoPaidOrderByUserBuyerId(Order order);
    public List<Order> GetNoPaidOrderByUserSellerId(Order order);

    /**
     * 获得已对账,未付款订单
     * @return
     */
    public List<Order> GetRecNoPaidOrderByUserBuyerId(Order order);
    public List<Order> GetRecNoPaidOrderByUserSellerId(Order order);


    public boolean InsertOrder(Order order);

    public List<Order> GetAccountPeriod(Order order);
    public int CountOverdueOrder(Order order);

    public int CountNoSendOrder(Order order);
    public int CountNoReceivingOrder(Order order);

    public String GetNewestOrderId();
    public boolean SetReceivingTime(Order order);
    public List<Order> GetOrderInfoByPayInfo(Order order);
    public boolean UpdateTotalPrice(String order_id);
    public boolean UpdatePaidPrice(Order order);

    public boolean UpdateReconciliation(String order_id);
}
