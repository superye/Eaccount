package com.eaccount.dao;

import com.eaccount.domain.Company_profile;
import com.eaccount.domain.Order_detail;
import com.eaccount.domain.Product;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yehao on 16/3/16.
 */
public class ProductDAO implements IProductDAO{
    @Override
    public List<Product> GetCompanyProductById(Company_profile company_profile) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        List<Product> list = new ArrayList<>();
        try {
            sqlSession = dbAccess.getSqlSession();
            list = sqlSession.selectList("Product.GetCompanyProductById", company_profile);
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
    public boolean DeleteProduct(Product product) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        try {
            sqlSession = dbAccess.getSqlSession();
            sqlSession.selectList("Product.DeleteProduct",product);
            sqlSession.selectList("Product.DeleteProductCompany",product);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return true;
    }

    @Override
    public boolean AddProduct(Product product) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        dbAccess.GetLog();
        try {
            sqlSession = dbAccess.getSqlSession();
            sqlSession.selectList("Product.AddProduct",product);
            sqlSession.selectList("Product.AddProductCompany",product);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return true;
    }
}
