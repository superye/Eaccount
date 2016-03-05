package com.eaccount.dao;

import com.eaccount.domain.User_profile;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by spzn on 16-3-5.
 */
public class UserDAO implements IUserDAO{
    @Override
    public List<User_profile> GetUserInfoByUserId(User_profile user_profile) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        List<User_profile> list = new ArrayList<User_profile>();
        try {
            sqlSession = dbAccess.getSqlSession();
            list = sqlSession.selectList("User_profile.SelectUserInfoByUserId", user_profile);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return list;
    }
}
