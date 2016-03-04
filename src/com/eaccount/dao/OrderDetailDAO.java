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
}
