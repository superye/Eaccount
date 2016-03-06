package com.eaccount.service;

import com.eaccount.dao.IMessageDAO;
import com.eaccount.dao.MessageDAO;
import com.eaccount.domain.Message_list;

/**
 * Created by yehao on 16/3/6.
 */
public class SendMessageService implements ISendMessageService{
    @Override
    public boolean SendMessage(Message_list message_list) {
        IMessageDAO messageDAO = new MessageDAO();
        messageDAO.SendMessage(message_list);
        return true;
    }
}
