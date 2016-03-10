package com.eaccount.service;

import com.eaccount.dao.CompanyDAO;
import com.eaccount.dao.ICompanyDAO;
import com.eaccount.dao.IUserDAO;
import com.eaccount.dao.UserDAO;
import com.eaccount.domain.Company_profile;
import com.eaccount.domain.User_profile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by spzn on 16-3-5.
 */
public class GetProfileService implements IGetProfileService{
    @Override
    public List<User_profile> GetSameCompanyUserInfoByUserId(String id) {
        List<User_profile> list = new ArrayList<>();
        User_profile user_profile = new User_profile();
        user_profile.setId(id);
        IUserDAO userDAO = new UserDAO();
        list = userDAO.GetSameCompanyUserInfoByUserId(user_profile);
        return list;
    }

    @Override
    public boolean CheckLogin(String user_phone_number, String user_password) {
        List<User_profile> list = new ArrayList<>();
        User_profile user_profile = new User_profile();
        user_profile.setUser_phone_number(user_phone_number);
        user_profile.setUser_password(user_password);
        IUserDAO userDAO = new UserDAO();
        list = userDAO.CheckLogin(user_profile);
        if (list.size() > 0)
            return true;
        return false;
    }

    @Override
    public List<User_profile> GetUserInfoByUserId(String id) {
        List<User_profile> list = new ArrayList<>();
        IUserDAO userDAO = new UserDAO();
        User_profile user_profile = new User_profile();
        user_profile.setId(id);
        list = userDAO.GetUserInfoByUserId(user_profile);
        return list;
    }

    @Override
    public List<Company_profile> GetCompanyInfoByCompanyId(String id) {
        List<Company_profile> list = new ArrayList<>();
        ICompanyDAO companyDAO = new CompanyDAO();
        Company_profile company_profile = new Company_profile();
        company_profile.setId(id);
        list = companyDAO.GetCompanyInfoByCompanyId(company_profile);
        return list;
    }
}
