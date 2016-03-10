package com.eaccount.dao;

import com.eaccount.domain.Company_profile;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by spzn on 16-3-10.
 */
public class CompanyDAO implements ICompanyDAO{
    @Override
    public List<Company_profile> GetCompanyInfoByCompanyId(Company_profile company_profile) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        List<Company_profile> list = new ArrayList<Company_profile>();
        try {
            sqlSession = dbAccess.getSqlSession();
            list = sqlSession.selectList("Company_profile.SelectCompanyInfoByCompanyId", company_profile);
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
