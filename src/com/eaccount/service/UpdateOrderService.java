package com.eaccount.service;

import com.eaccount.dao.IOrderDAO;
import com.eaccount.dao.IOrderDetailDAO;
import com.eaccount.dao.OrderDAO;
import com.eaccount.dao.OrderDetailDAO;
import com.eaccount.domain.Order;
import com.eaccount.domain.Order_detail;

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

    @Override
    public boolean UpdateQuantity(String id, String type) {
        Order_detail order_detail = new Order_detail();
        order_detail.setId(id);
        order_detail.setType(type);

        IOrderDetailDAO orderDetailDAO = new OrderDetailDAO();
        return orderDetailDAO.UpdateQuantity(order_detail);
    }

    @Override
    public boolean BuyerSetQuantity(String id, String quantity) {
        Order_detail order_detail = new Order_detail();
        order_detail.setId(id);
        order_detail.setQuantity_receiving(quantity);

        IOrderDetailDAO orderDetailDAO = new OrderDetailDAO();
        return orderDetailDAO.BuyerSetQuantity(order_detail);
    }

}
