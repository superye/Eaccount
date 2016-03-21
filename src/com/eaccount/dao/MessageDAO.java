package com.eaccount.dao;

import com.eaccount.domain.Message_list;
import com.eaccount.domain.Order;
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

    @Override
    public boolean SendMessage(Message_list message_list) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        List<Message_list> list = new ArrayList<Message_list>();
        try {
            sqlSession = dbAccess.getSqlSession();
            list = sqlSession.selectList("Message_list.InsertMessage", message_list);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return true;
    }

    @Override
    public int CountUnreadMessage(Message_list message_list) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        List<Integer> list = new ArrayList<Integer>();
        try {
            sqlSession = dbAccess.getSqlSession();
            list = sqlSession.selectList("Message_list.CountUnreadMessage", message_list);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        if (list.size() == 0) return 0;
        return list.get(0);
    }

    @Override
    public boolean ReadMessage(Message_list message_list) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        int cnt = 0;
        try {
            sqlSession = dbAccess.getSqlSession();
            cnt = sqlSession.update("Message_list.ReadMessage", message_list);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        if (cnt == 0) return false;
        return true;
    }
}
