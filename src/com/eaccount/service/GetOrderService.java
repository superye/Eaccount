package com.eaccount.service;

import com.eaccount.dao.IOrderDAO;
import com.eaccount.dao.IOrderDetailDAO;
import com.eaccount.dao.OrderDAO;
import com.eaccount.dao.OrderDetailDAO;
import com.eaccount.domain.Order;
import com.eaccount.domain.Order_detail;
import com.eaccount.util.GetNowTime;

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
    public List<Order> GetOrderByOrderId(String id, String type) {
        List<Order> list = new ArrayList<>();
        IOrderDAO orderDAO = new OrderDAO();
        Order order = new Order();
        order.setOrder_id(id);
        order.setType(type);
        if ("1".equals(type)) {
            list = orderDAO.SellerGetOrderMessageByOrderId(order);
        } else {
            list = orderDAO.BuyerGetOrderMessageByOrderId(order);
        }
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
    public int GetCountPayment(String company_id1, String company_id2, String type) {
        Order order = new Order();
        IOrderDAO orderDAO = new OrderDAO();
        int ans = 0;
        if ("1".equals(type)) {
            order.setType("1");
            order.setCompany_id_buyer(company_id1);
            order.setCompany_id_seller(company_id2);
            ans = orderDAO.GetCountPayment(order);
        } else {
            order.setType("2");
            order.setCompany_id_seller(company_id1);
            order.setCompany_id_buyer(company_id2);
            ans = orderDAO.GetCountPayment(order);
        }
        return ans;
    }

    @Override
    public int GetCountMattrOrder(String company_id1, String company_id2, String type) {
        Order order = new Order();
        IOrderDAO orderDAO = new OrderDAO();
        int ans = 0;
        if ("1".equals(type)) {
            order.setType("1");
            order.setCompany_id_buyer(company_id1);
            order.setCompany_id_seller(company_id2);
            ans = orderDAO.GetCountMatterOrder(order);
        } else {
            order.setType("2");
            order.setCompany_id_seller(company_id1);
            order.setCompany_id_buyer(company_id2);
            ans = orderDAO.GetCountMatterOrder(order);
        }
        return ans;
    }

    @Override
    public List<Order> GetMatterOrderInfo(String company_id1, String company_id2, String type) {
        List<Order> list = new ArrayList<>();
        IOrderDAO orderDAO = new OrderDAO();
        Order order = new Order();
        if ("1".equals(type)) {
            order.setType("1");
            order.setCompany_id_buyer(company_id1);
            order.setCompany_id_seller(company_id2);
        } else {
            order.setType("2");
            order.setCompany_id_seller(company_id1);
            order.setCompany_id_buyer(company_id2);
        }
        list = orderDAO.GetMatterOrderInfo(order);
        return list;
    }

    @Override
    public List<Order> GetMatterOrderDetailInfo(String company_id1, String company_id2, String type, String is_reconciliation) {
        List<Order> list = new ArrayList<>();
        IOrderDAO orderDAO = new OrderDAO();
        Order order = new Order();
        order.setIs_reconciliation(is_reconciliation);
        if ("1".equals(type)) {
            order.setType("1");
            order.setCompany_id_buyer(company_id1);
            order.setCompany_id_seller(company_id2);
        } else {
            order.setType("2");
            order.setCompany_id_seller(company_id1);
            order.setCompany_id_buyer(company_id2);
        }
        list = orderDAO.GetMatterOrderDetailInfo(order);
        return list;
    }

    @Override
    public List<Order_detail> GetOrderDetailByMatterOrderId(String id) {
        List<Order_detail> list = new ArrayList<>();
        IOrderDetailDAO orderDetailDAO = new OrderDetailDAO();
        Order_detail order_detail = new Order_detail();
        order_detail.setOrder_id(id);
        list = orderDetailDAO.GetOrderDetailInfoByMatterOrderId(order_detail);
        return list;
    }

    @Override
    public List<Order> GetAccountPeriod(String user_id, String type) {
        Order order = new Order();
        order.setType(type);
        order.setReceiving_time(new GetNowTime().GetTime(1));
        if ("1".equals(type)) {
            order.setUser_id_seller(user_id);
        } else if ("2".equals(type)) {
            order.setUser_id_buyer(user_id);
        }
        IOrderDAO orderDAO = new OrderDAO();
        List<Order> list = new ArrayList<>();
        list = orderDAO.GetAccountPeriod(order);
        return list;
    }

    @Override
    public int CountOverdueOrder(String user_id) {
        Order order = new Order();
        order.setUser_id_seller(user_id);
        order.setUser_id_buyer(user_id);
        IOrderDAO orderDAO = new OrderDAO();
        int ans = 0;
        ans = orderDAO.CountOverdueOrder(order);
        return ans;
    }

    @Override
    public int CountNotSendOrReceivingOrder(String user_id, String type) {
        Order order = new Order();
        IOrderDAO orderDAO = new OrderDAO();
        int ans = 0;
        if ("1".equals(type)) {
            order.setUser_id_seller(user_id);
            ans = orderDAO.CountNoSendOrder(order);
        } else {
            order.setUser_id_buyer(user_id);
            ans = orderDAO.CountNoReceivingOrder(order);
        }
        return ans;
    }

    @Override
    public String GetNewestOrderId() {
        IOrderDAO orderDAO = new OrderDAO();
        String ans = null;
        ans = orderDAO.GetNewestOrderId();
        return ans;
    }

    @Override
    public String GetOrderIdByOrderDetailId(String id) {
        IOrderDetailDAO orderDetailDAO = new OrderDetailDAO();
        Order_detail order_detail = new Order_detail();
        order_detail.setId(id);
        return orderDetailDAO.GetOrderIdBuyOrderDetailId(order_detail);
    }
}
