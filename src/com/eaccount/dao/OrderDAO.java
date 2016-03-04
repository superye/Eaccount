package com.eaccount.dao;

import com.eaccount.domain.Order;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by spzn on 16-3-3.
 */
public class OrderDAO implements IOrderDAO{
    @Override
    public List<Order> SellerGetOrderMessageByUserId(Order order) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        List<Order> list = new ArrayList<Order>();
        try {
            sqlSession = dbAccess.getSqlSession();
            list = sqlSession.selectList("Order.SelectOrderInfoByUserId", order);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return list;
    }

    @Override
    public List<Order> SellerGetOrderMessageByOrderId(Order order) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        List<Order> list = new ArrayList<Order>();
        try {
            sqlSession = dbAccess.getSqlSession();
            list = sqlSession.selectList("Order.SelectOrderInfoByOrderId", order);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return list;
    }
}
