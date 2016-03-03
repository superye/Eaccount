package com.eaccount.service;

import com.eaccount.domain.Company_profile;
import com.eaccount.domain.Product;
import com.eaccount.domain.User_profile;

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

}
