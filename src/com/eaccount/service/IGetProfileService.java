package com.eaccount.service;

import com.eaccount.domain.User_profile;

import java.util.List;

/**
 * Created by spzn on 16-3-5.
 */
public interface IGetProfileService {
    public List<User_profile> GetUserInfoByUserId(String id);
}
