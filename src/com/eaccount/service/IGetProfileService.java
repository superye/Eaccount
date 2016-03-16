package com.eaccount.service;

import com.eaccount.domain.Company_profile;
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
}