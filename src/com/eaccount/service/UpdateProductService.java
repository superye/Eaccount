package com.eaccount.service;

import com.eaccount.dao.IProductDAO;
import com.eaccount.dao.ProductDAO;
import com.eaccount.domain.Product;

/**
 * Created by yehao on 16/3/21.
 */
public class UpdateProductService implements IUpdateProductService {
    @Override
    public boolean DeleteProduct(String id) {
        Product product = new Product();
        product.setId(id);

        IProductDAO productDAO = new ProductDAO();
        productDAO.DeleteProduct(product);
        return true;
    }

    @Override
    public boolean AddProduct(Product product) {
        IProductDAO productDAO = new ProductDAO();
        productDAO.AddProduct(product);

        return true;
    }
}
