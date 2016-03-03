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
    public List<Order> GetOrderMessage(Order order) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        List<Order> list = new ArrayList<Order>();
        try {
            sqlSession = dbAccess.getSqlSession();
            list = sqlSession.selectList("Order.SelectOrderInfoById", order);
            sqlSession.commit();
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
