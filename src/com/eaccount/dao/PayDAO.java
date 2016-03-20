package com.eaccount.dao;

import com.eaccount.domain.Pay;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

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
}
