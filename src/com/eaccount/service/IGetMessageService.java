package com.eaccount.service;

import com.eaccount.domain.Company_profile;
import com.eaccount.domain.Message_list;
import com.eaccount.domain.Product;
import com.eaccount.domain.User_profile;

import java.util.List;

/**
 * Created by spzn on 16-3-3.
 */
public interface IGetMessageService {
    public User_profile GetUserMessageById(int id);
    public Company_profile GetCompanyMessageById(int id);
    public Product GetProductMessageById(int id);

    public List<Message_list> GetMessageById(String id);
    public int CountUnreadMessage(String user_id);

    public boolean ReadMessage(String id, String type);
}
