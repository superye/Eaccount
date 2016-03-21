package com.eaccount.dao;

import com.eaccount.domain.Company_profile;
import com.eaccount.domain.Product;

import java.util.List;

/**
 * Created by yehao on 16/3/16.
 */
public interface IProductDAO {
    public List<Product> GetCompanyProductById(Company_profile company_profile);
    public boolean DeleteProduct(Product product);
    public boolean AddProduct(Product product);
}

