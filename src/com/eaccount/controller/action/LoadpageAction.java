package com.eaccount.controller.action;

import com.eaccount.domain.Product;
import com.eaccount.service.GetProfileService;
import com.eaccount.service.IGetProfileService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yehao on 16/3/16.
 */
public class LoadpageAction extends SuperAction{
    public String LoadPlaceorderPage() {
        List<Product> list = new ArrayList<>();
        IGetProfileService getProfileService = new GetProfileService();
        list = getProfileService.GetCompanyProductById(request.getParameter("company_id_seller"));
        request.setAttribute("productList", list);


        return "placeOrder";
    }
}
