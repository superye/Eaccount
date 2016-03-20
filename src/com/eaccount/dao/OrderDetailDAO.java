package com.eaccount.dao;

import com.eaccount.domain.Order_detail;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by spzn on 16-3-4.
 */
public class OrderDetailDAO implements IOrderDetailDAO{
    @Override
    public List<Order_detail> SellerGetOrderDetailInfoByOrderId(Order_detail order_detail) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        List<Order_detail> list = new ArrayList<Order_detail>();
        try {
            sqlSession = dbAccess.getSqlSession();
            list = sqlSession.selectList("Order_detail.SelectOrderDetailInfoByOrderId", order_detail);
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
    public List<Order_detail> GetOrderDetailInfoByMatterOrderId(Order_detail order_detail) {
         DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        List<Order_detail> list = new ArrayList<Order_detail>();
        try {
            sqlSession = dbAccess.getSqlSession();
            list = sqlSession.selectList("Order_detail.SelectOrderDetailInfoByMatterOrderId", order_detail);
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
    public boolean UpdateQuantity(Order_detail order_detail) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        boolean flag = false;
        int cnt = 0;
        try {
            sqlSession = dbAccess.getSqlSession();
            if ("1".equals(order_detail.getType())) {
                cnt = sqlSession.update("Order_detail.SellerUpdateQuantity", order_detail);
            } else {
                cnt = sqlSession.update("Order_detail.BuyerUpdateQuantity", order_detail);
            }
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        if (cnt != 0) flag = true;
        return flag;
    }

    @Override
    public boolean BuyerSetQuantity(Order_detail order_detail) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        boolean flag = false;
        int cnt = 0;
        try {
            sqlSession = dbAccess.getSqlSession();
            cnt = sqlSession.update("Order_detail.BuyerSetQuantity", order_detail);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        if (cnt != 0) flag = true;
        return flag;
    }

    @Override
    public String GetOrderIdBuyOrderDetailId(Order_detail order_detail) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        List<String> list = new ArrayList<>();
        try {
            sqlSession = dbAccess.getSqlSession();
            list = sqlSession.selectList("Order_detail.SelectOrderIdByOrderDetailId", order_detail);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return list.get(0);
    }
}
