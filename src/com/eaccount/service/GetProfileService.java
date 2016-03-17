package com.eaccount.service;

import com.eaccount.dao.*;
import com.eaccount.domain.Company_profile;
import com.eaccount.domain.Product;
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
    public List<User_profile> CheckLogin(String user_phone_number, String user_password) {
        List<User_profile> list = new ArrayList<>();
        User_profile user_profile = new User_profile();
        user_profile.setUser_phone_number(user_phone_number);
        user_profile.setUser_password(user_password);
        IUserDAO userDAO = new UserDAO();
        list = userDAO.CheckLogin(user_profile);
        return list;
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

    @Override
    public List<Product> GetCompanyProductById(String id) {
        List<Product> list = new ArrayList<>();
        IProductDAO productDAO = new ProductDAO();

        Company_profile company_profile = new Company_profile();
        company_profile.setId(id);
        list = productDAO.GetCompanyProductById(company_profile);
        return list;

    }

    @Override
    public List<Company_profile> GetAllCompany() {
        List<Company_profile> list = new ArrayList<>();
        ICompanyDAO companyDAO = new CompanyDAO();
        list = companyDAO.GetAllCompany();

        return list;
    }

    @Override
    public List<User_profile> GetUserByCompanyId(String id) {
        IUserDAO userDAO = new UserDAO();
        List<User_profile> list = new ArrayList<>();
        Company_profile company_profile = new Company_profile();
        company_profile.setId(id);

        list = userDAO.GetUserByCompanyId(company_profile);
        return list;
    }
}
