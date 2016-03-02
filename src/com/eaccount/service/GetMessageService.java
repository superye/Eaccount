package com.eaccount.service;

import com.eaccount.domain.Company_profile;
import com.eaccount.domain.Product;
import com.eaccount.domain.User_profile;

/**
 * Created by yehao on 16/3/2.
 */
public interface GetMessageService {
    public User_profile GetUserMessageById(int id);
    public Company_profile GetCompanyMessageById(int id);
    public Product GetProductMessageById(int id);

}
