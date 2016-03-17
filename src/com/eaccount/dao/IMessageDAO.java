package com.eaccount.dao;

import com.eaccount.domain.Message_list;
import com.eaccount.domain.Order;

import java.util.List;

/**
 * Created by yehao on 16/3/5.
 */
public interface IMessageDAO {
    public List<Message_list> SelectMessageByUserId(Order order);
    public boolean SendMessage(Message_list message_list);
    public int CountUnreadMessage(Message_list message_list);
}
