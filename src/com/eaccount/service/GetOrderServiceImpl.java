package com.eaccount.service;

import com.eaccount.domain.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yehao on 16/3/2.
 */
public class GetOrderServiceImpl implements GetOrderService{
    /**
     * 通过卖方id获取订单
     * @param id
     * @return
     */
    public List<Order> GetOrderByUserIdSeller(int id) {
        List<Order> list = new ArrayList<>();
        /**
         * operation 按时间降序
         */
        return  list;
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

    /**
     * 通过订单id获取订单详情
     * @param id
     * @return
     */
    @Override
    public List<Order> GetOrderDetailByOrderId(int id) {
        List<Order> list = new ArrayList<>();
        return list;
    }
}
