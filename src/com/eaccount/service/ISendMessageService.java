package com.eaccount.service;

import com.eaccount.domain.Message_list;

/**
 * Created by yehao on 16/3/6.
 */
public interface ISendMessageService {
    public  boolean SendMessage(Message_list message_list);
}
