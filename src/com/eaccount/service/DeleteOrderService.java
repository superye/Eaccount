package com.eaccount.service;

import com.eaccount.dao.IOrderDAO;
import com.eaccount.dao.OrderDAO;
import com.eaccount.domain.Order;

/**
 * Created by spzn on 16-3-6.
 */
public class DeleteOrderService implements IDeleteOrderService{
    @Override
    public boolean DeleteOrderInfoByOrderId(String order_id) {
        boolean flag = false;
        Order order = new Order();
        order.setOrder_id(order_id);
        IOrderDAO orderDAO = new OrderDAO();
        flag = orderDAO.DeleteOrderInfoByOrderId(order);
        return flag;
    }
}
