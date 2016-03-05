package com.eaccount.dao;

import com.eaccount.domain.Message_list;
import com.eaccount.domain.Order;
import com.eaccount.domain.User_profile;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yehao on 16/3/5.
 */
public class MessageDAO implements IMessageDAO{
    @Override
    public List<Message_list> SelectMessageByUserId(Order order) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        List<Message_list> list = new ArrayList<Message_list>();
        try {
            sqlSession = dbAccess.getSqlSession();
            list = sqlSession.selectList("Message_list.SelectMessageByUserId", order);
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
