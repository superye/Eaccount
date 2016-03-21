package com.eaccount.dao;

import com.eaccount.domain.Company_profile;
import com.eaccount.domain.User_company;
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
    public List<User_profile> GetSameCompanyUserInfoByUserId(User_profile user_profile) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        List<User_profile> list = new ArrayList<User_profile>();
        try {
            sqlSession = dbAccess.getSqlSession();
            list = sqlSession.selectList("User_profile.SelectSameCompanyUserInfoByUserId", user_profile);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return list;
    }

    @Override
    public List<User_profile> CheckLogin(User_profile user_profile) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        List<User_profile> list = new ArrayList<User_profile>();
        try {
            sqlSession = dbAccess.getSqlSession();
            list = sqlSession.selectList("User_profile.CheckLogin", user_profile);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return list;
    }

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

    @Override
    public List<User_profile> GetUserByCompanyId(Company_profile company_profile) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        List<User_profile> list = new ArrayList<User_profile>();
        try {
            sqlSession = dbAccess.getSqlSession();
            if ("1".equals(company_profile.getType())) {
                list = sqlSession.selectList("User_profile.GetUserByCompanyId", company_profile);
            } else {
                list = sqlSession.selectList("User_profile.GetSettleUserByCompanyId", company_profile);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return list;
    }

    @Override
    public List<User_profile> GetUserIdByPhone(User_profile user_profile) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        List<User_profile> list = new ArrayList<User_profile>();
        try {
            sqlSession = dbAccess.getSqlSession();
            list = sqlSession.selectList("User_profile.SelectUserIdByPhone", user_profile);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return list;
    }

    @Override
    public String GetCompanyIdByUserId(User_company user_company) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        List<String> list = new ArrayList<String>();
        try {
            sqlSession = dbAccess.getSqlSession();
            list = sqlSession.selectList("User_company.SelectCompanyIdByUserId", user_company);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return list.get(0);
    }
}
