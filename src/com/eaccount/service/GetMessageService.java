package com.eaccount.service;

import com.eaccount.dao.IMessageDAO;
import com.eaccount.dao.MessageDAO;
import com.eaccount.domain.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yehao on 16/3/2.
 */
public class GetMessageService implements IGetMessageService{

    /**
     * 获取用户详情
     * @param id
     * @return
     */
    @Override
    public User_profile GetUserMessageById(int id) {
        User_profile user_profile = new User_profile();

        return user_profile;
    }

    /**
     * 获取公司详情`
     * @param id
     * @return
     */
    @Override
    public Company_profile GetCompanyMessageById(int id) {
        Company_profile company_profile = new Company_profile();

        return company_profile;
    }

    /**
     * 获取商品详情
     * @param id
     * @return
     */
    @Override
    public Product GetProductMessageById(int id) {
        Product product = new Product();

        return product;
    }

    @Override
    public List<Message_list> GetMessageById(String id) {
        List<Message_list> list = new ArrayList<>();
        IMessageDAO iMessageDAO = new MessageDAO();
        Order order = new Order();
        order.setId(id);
        list = iMessageDAO.SelectMessageByUserId(order);
        return list;
    }

    @Override
    public int CountUnreadMessage(String user_id) {
        Message_list message_list = new Message_list();
        message_list.setMessage_receiver(user_id);
        IMessageDAO messageDAO = new MessageDAO();
        int ans = 0;
        ans = messageDAO.CountUnreadMessage(message_list);
        return ans;
    }
}
