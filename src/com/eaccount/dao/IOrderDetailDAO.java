package com.eaccount.dao;

import com.eaccount.domain.Order_detail;

import java.util.List;

/**
 * Created by spzn on 16-3-4.
 */
public interface IOrderDetailDAO {
    //卖方通过订单ID获取订单明细信息
    public List<Order_detail> SellerGetOrderDetailInfoByOrderId(Order_detail order_detail);
    public List<Order_detail> GetOrderDetailInfoByMatterOrderId(Order_detail order_detail);
}
