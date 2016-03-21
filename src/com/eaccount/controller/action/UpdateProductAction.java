package com.eaccount.controller.action;

import com.eaccount.domain.Product;
import com.eaccount.service.IUpdateProductService;
import com.eaccount.service.UpdateProductService;
import net.sf.json.JSONObject;

/**
 * Created by yehao on 16/3/21.
 */
public class UpdateProductAction extends SuperAction{

    public void DeleteProduct() {
        String id = request.getParameter("id");
        IUpdateProductService updateProductService = new UpdateProductService();
        updateProductService.DeleteProduct(id);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", "success");
        try {
            byte[] jsonBytes = jsonObject.toString().getBytes("utf-8");
            response.setContentType("text/html;charset=utf-8");
            response.setContentLength(jsonBytes.length);
            response.getOutputStream().write(jsonBytes);
            response.getOutputStream().flush();
            response.getOutputStream().close();
        } catch (Exception e){}
    }

    public void AddProduct() {
        String product_name = request.getParameter("product_name");
        String product_specification = request.getParameter("product_specification");
        String company_id = session.getAttribute("company_id_seller").toString();

        Product product = new Product();
        product.setCompany_id(company_id);
        product.setProduct_name(product_name);
        product.setProduct_specification(product_specification);

        IUpdateProductService productService = new UpdateProductService();
        productService.AddProduct(product);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", "success");
        try {
            byte[] jsonBytes = jsonObject.toString().getBytes("utf-8");
            response.setContentType("text/html;charset=utf-8");
            response.setContentLength(jsonBytes.length);
            response.getOutputStream().write(jsonBytes);
            response.getOutputStream().flush();
            response.getOutputStream().close();
        } catch (Exception e){}
    }
}
