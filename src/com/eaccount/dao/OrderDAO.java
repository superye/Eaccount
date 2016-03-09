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
            list = sqlSession.selectList("Order.SelectOrderInfoByUserSellerId", order);
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
    public List<Order> BuyerGetOrderMessageByUserId(Order order) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        List<Order> list = new ArrayList<Order>();
        try {
            sqlSession = dbAccess.getSqlSession();
            list = sqlSession.selectList("Order.SelectOrderInfoByUserBuyerId", order);
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

    @Override
    public boolean UpdateOrderSellerId(Order order) {
        int flag = 0;
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        try {
            sqlSession = dbAccess.getSqlSession();
            flag = sqlSession.update("Order.UpdateOrderSellerId", order);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        if (flag != 0) return true;
        else return false;
    }

    @Override
    public boolean DeleteOrderInfoByOrderId(Order order) {
        int flag = 0;
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            flag += sqlSession.delete("Order.DeleteOrderByOrderId", order);
            flag += sqlSession.delete("Order.DeleteOrderDetailByOrderId", order);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        if (flag != 0) return true;
        else return false;
    }

    @Override
    public List<Order> GetNoPaidOrderByUserBuyerId(Order order) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        List<Order> list = new ArrayList<Order>();
        try {
            sqlSession = dbAccess.getSqlSession();
            list = sqlSession.selectList("Order.SelectReconciliationByBuyerId", order);
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
    public List<Order> GetNoPaidOrderByUserSellerId(Order order) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        List<Order> list = new ArrayList<Order>();
        try {
            sqlSession = dbAccess.getSqlSession();
            list = sqlSession.selectList("Order.SelectReconciliationBySellerId", order);
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
    public List<Order> GetPayListByUserBuyerId(Order order) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        List<Order> list = new ArrayList<Order>();
        try {
            sqlSession = dbAccess.getSqlSession();
            list = sqlSession.selectList("Order.SelectPayListByUserBuyerId", order);
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
    public List<Order> GetPayListByUserSellerId(Order order) {
        return null;
    }
}
