package com.eaccount.service;

import com.eaccount.domain.Company_profile;
import com.eaccount.domain.Product;
import com.eaccount.domain.User_profile;

import java.util.List;

/**
 * Created by spzn on 16-3-5.
 */
public interface IGetProfileService {
    public List<User_profile> GetSameCompanyUserInfoByUserId(String id);
    public List<User_profile> GetUserInfoByUserId(String id);
    public List<Company_profile> GetCompanyInfoByCompanyId(String id);
    public List<User_profile> CheckLogin(String user_phone_number, String user_password);
    public List<Product> GetCompanyProductById(String id);
    public String GetUserIdByPhone(String phone_number);
    public List<Company_profile> GetAllCompany();
    public List<User_profile> GetUserByCompanyId(String id);
    public String GetCompanyIdByUserId(String user_id);
}
