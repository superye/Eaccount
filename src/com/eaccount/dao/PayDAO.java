package com.eaccount.dao;

import com.eaccount.domain.Pay;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by spzn on 16-3-20.
 */
public class PayDAO implements IPayDAO{
    @Override
    public boolean AddPayInfo(Pay pay) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        boolean flag = false;
        int cnt = 0;
        try {
            sqlSession = dbAccess.getSqlSession();
            cnt = sqlSession.update("Pay.InsertPayInfo", pay);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        if (cnt != 0) flag = true;
        return flag;
    }

    @Override
    public List<Pay> GetPayInfoByCompanyId(String company_id) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        List<Pay> list = new ArrayList<Pay>();
        try {
            sqlSession = dbAccess.getSqlSession();
            list = sqlSession.selectList("Pay.SelectPayInfoByCompanyId", company_id);
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
    public Pay GetPayInfoByPayId(String pay_id) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        List<Pay> list = new ArrayList<Pay>();
        try {
            sqlSession = dbAccess.getSqlSession();
            list = sqlSession.selectList("Pay.SelectPayInfoByPayId", pay_id);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return list.get(0);
    }

    @Override
    public boolean UpdateAmountOfMoney(Pay pay) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        boolean flag = false;
        int cnt = 0;
        try {
            sqlSession = dbAccess.getSqlSession();
            cnt = sqlSession.update("Pay.UpdateAmountOfMoney", pay);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        if (cnt != 0) flag = true;
        return flag;
    }

    @Override
    public boolean UpdatePayState(String pay_id) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        boolean flag = false;
        int cnt = 0;
        try {
            sqlSession = dbAccess.getSqlSession();
            cnt = sqlSession.update("Pay.UpdatePayState", pay_id);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        if (cnt != 0) flag = true;
        return flag;
    }
}
