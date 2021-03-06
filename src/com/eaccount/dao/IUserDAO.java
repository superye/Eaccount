package com.eaccount.dao;

import com.eaccount.domain.Company_profile;
import com.eaccount.domain.User_company;
import com.eaccount.domain.User_profile;

import java.util.List;

/**
 * Created by spzn on 16-3-5.
 */
public interface IUserDAO {
    public List<User_profile> GetSameCompanyUserInfoByUserId(User_profile user_profile);
    public List<User_profile> GetUserInfoByUserId(User_profile user_profile);
    public List<User_profile> CheckLogin(User_profile user_profile);

    public List<User_profile> GetUserByCompanyId(Company_profile company_profile);
    public List<User_profile> GetUserIdByPhone(User_profile user_profile);
    public String GetCompanyIdByUserId(User_company user_company);
}
