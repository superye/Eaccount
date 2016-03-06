package com.eaccount.service;

import com.eaccount.domain.User_profile;

import java.util.List;

/**
 * Created by spzn on 16-3-5.
 */
public interface IGetProfileService {
    public List<User_profile> GetUserInfoByUserId(String id);
    public boolean CheckLogin(String user_phone_number, String user_password);
}
