package com.eaccount.service;

import com.eaccount.domain.Order;
import com.eaccount.domain.Order_detail;

/**
 * Created by spzn on 16-3-6.
 */
public interface IUpdateOrderService {
    public boolean UpdateOrderSellerId(String order_id, String user_id, String type);
    public boolean InsertOrder(Order order);
    public boolean UpdateQuantity(String id, String type);
    public boolean BuyerSetQuantity(String id, String quantity);
    public boolean InsertOrderDetails(Order_detail order_detail);
    public boolean SetReceivingTime(String id, String time);
    public boolean UpdateTotalPrice(String order_id);
    public boolean UpdatePaidPrice(String order_id, String paid_price);
}
