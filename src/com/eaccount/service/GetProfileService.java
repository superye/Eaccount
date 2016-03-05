package com.eaccount.service;

import com.eaccount.dao.IUserDAO;
import com.eaccount.dao.UserDAO;
import com.eaccount.domain.User_profile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by spzn on 16-3-5.
 */
public class GetProfileService implements IGetProfileService{
    @Override
    public List<User_profile> GetUserInfoByUserId(String id) {
        List<User_profile> list = new ArrayList<>();
        User_profile user_profile = new User_profile();
        user_profile.setId(id);
        IUserDAO userDAO = new UserDAO();
        list = userDAO.GetUserInfoByUserId(user_profile);
        return list;
    }
}
