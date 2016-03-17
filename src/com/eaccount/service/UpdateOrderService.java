package com.eaccount.service;

import com.eaccount.dao.IOrderDAO;
import com.eaccount.dao.OrderDAO;
import com.eaccount.domain.Order;

/**
 * Created by spzn on 16-3-6.
 */
public class UpdateOrderService implements IUpdateOrderService{
    @Override
    public boolean UpdateOrderSellerId(String order_id, String user_id, String type) {
        Order order = new Order();
        order.setOrder_id(order_id);
        if ("1".equals(type)) {
            order.setUser_id_seller(user_id);
        } else {
            order.setUser_id_buyer(user_id);
        }
        order.setType(type);
        IOrderDAO orderDAO = new OrderDAO();
        boolean flag = false;
        if ("1".equals(type)) {
            flag = orderDAO.UpdateOrderSellerId(order);
        } else {
            flag = orderDAO.UpdateOrderBuyerId(order);
        }
        return flag;
    }

    @Override
    public boolean InsertOrder(Order order) {
        IOrderDAO orderDAO = new OrderDAO();
        orderDAO.InsertOrder(order);
        return true;
    }
}
