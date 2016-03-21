package com.eaccount.service;

import com.eaccount.domain.Product;

/**
 * Created by yehao on 16/3/21.
 */
public interface IUpdateProductService {
    public boolean DeleteProduct(String id);
    public boolean AddProduct(Product product);
}
