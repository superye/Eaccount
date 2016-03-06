package com.eaccount.dao;

import com.eaccount.domain.User_profile;

import java.util.List;

/**
 * Created by spzn on 16-3-5.
 */
public interface IUserDAO {
    public List<User_profile> GetUserInfoByUserId(User_profile user_profile);
    public List<User_profile> CheckLogin(User_profile user_profile);
}
