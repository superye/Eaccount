package com.eaccount.service;

import com.eaccount.dao.IOrderDAO;
import com.eaccount.dao.IOrderDetailDAO;
import com.eaccount.dao.OrderDAO;
import com.eaccount.dao.OrderDetailDAO;
import com.eaccount.domain.Order;
import com.eaccount.domain.Order_detail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yehao on 16/3/2.
 */
public class GetOrderService implements IGetOrderService{
    /**
     * 通过卖方id获取订单
     * @param id
     * @return
     */
    public List<Order> GetOrderByUserIdSeller(String id, String type) {
        List<Order> list = new ArrayList<>();
        IOrderDAO orderDAO = new OrderDAO();
        Order order = new Order();
        order.setUser_id_seller(String.valueOf(id));
        order.setType(type);
        list = orderDAO.SellerGetOrderMessageByUserId(order);
        return list;
    }

    @Override
    public List<Order> GetOrderByUserIdBuyer(String id, String type) {
        List<Order> list = new ArrayList<>();
        IOrderDAO orderDAO = new OrderDAO();
        Order order = new Order();
        order.setUser_id_buyer(String.valueOf(id));
        order.setType(type);
        list = orderDAO.BuyerGetOrderMessageByUserId(order);
        return list;
    }

    /**
     * 通过买方id获取订单
     * @param id
     * @return
     */
    public List<Order> GetOrderByUserIdBuyer(int id) {
        List<Order> list = new ArrayList<>();
        /**
         * operation 按时间降序
         */
        return  list;
    }

    @Override
    public List<Order> GetOrderByOrderId(String id) {
        List<Order> list = new ArrayList<>();
        IOrderDAO orderDAO = new OrderDAO();
        Order order = new Order();
        order.setOrder_id(id);
        list = orderDAO.SellerGetOrderMessageByOrderId(order);
        return list;
    }

    /**
     * 通过订单id获取订单详情
     * @param id
     * @return
     */
    @Override
    public List<Order_detail> GetOrderDetailByOrderId(String id) {

        List<Order_detail> list = new ArrayList<>();
        IOrderDetailDAO orderDetailDAO = new OrderDetailDAO();
        Order_detail order_detail = new Order_detail();
        order_detail.setOrder_id(id);
        list = orderDetailDAO.SellerGetOrderDetailInfoByOrderId(order_detail);

        return list;
    }

    /**
     * 获取未对账帐单
     * @param id
     * @return
     */
    @Override
    public List<Order> GetNoPaidOrderByUserBuyerId(String id) {
        List<Order>  list = new ArrayList<>();
        IOrderDAO orderDAO = new OrderDAO();
        Order order = new Order();
        order.setUser_id_buyer(id);
        list = orderDAO.GetNoPaidOrderByUserBuyerId(order);

        return list;
    }

    @Override
    public List<Order> GetNoPaidOrderByUserSellerId(String id) {
        List<Order>  list = new ArrayList<>();
        IOrderDAO orderDAO = new OrderDAO();
        Order order = new Order();
        order.setUser_id_seller(id);
        list = orderDAO.GetNoPaidOrderByUserSellerId(order);

        return list;
    }

    @Override
    public List<Order> GetPayListByUserBuyerId(String userId, String companyId) {
        List<Order>  list = new ArrayList<>();
        IOrderDAO orderDAO = new OrderDAO();
        Order order = new Order();
        order.setUser_id_buyer(userId);
        order.setCompany_id_seller(companyId);
        list = orderDAO.GetPayListByUserBuyerId(order);

        return list;
    }

    @Override
    public int GetCountPayment(String user_id, String company_id, String type) {
        Order order = new Order();
        IOrderDAO orderDAO = new OrderDAO();
        int ans = 0;
        if ("1".equals(type)) {
            order.setType("1");
            order.setUser_id_buyer(user_id);
            order.setCompany_id_seller(company_id);
            ans = orderDAO.GetCountPayment(order);
        } else {
            order.setType("2");
            order.setUser_id_seller(user_id);
            order.setCompany_id_buyer(company_id);
            ans = orderDAO.GetCountPayment(order);
        }
        return ans;
    }

    @Override
    public int GetCountMattrOrder(String user_id, String company_id, String type) {
        Order order = new Order();
        IOrderDAO orderDAO = new OrderDAO();
        int ans = 0;
        if ("1".equals(type)) {
            order.setType("1");
            order.setUser_id_buyer(user_id);
            order.setCompany_id_seller(company_id);
            ans = orderDAO.GetCountMatterOrder(order);
        } else {
            order.setType("2");
            order.setUser_id_seller(user_id);
            order.setCompany_id_buyer(company_id);
            ans = orderDAO.GetCountMatterOrder(order);
        }
        return ans;
    }
}
