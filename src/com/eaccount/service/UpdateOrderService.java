package com.eaccount.service;

import com.eaccount.dao.IOrderDAO;
import com.eaccount.dao.OrderDAO;
import com.eaccount.domain.Order;

/**
 * Created by spzn on 16-3-6.
 */
public class UpdateOrderService implements IUpdateOrderService{
    @Override
    public boolean UpdateOrderSellerId(String order_id, String user_id) {
        Order order = new Order();
        order.setOrder_id(order_id);
        order.setUser_id_seller(user_id);
        IOrderDAO orderDAO = new OrderDAO();
        boolean flag = orderDAO.UpdateOrderSellerId(order);
        return flag;
    }
}
