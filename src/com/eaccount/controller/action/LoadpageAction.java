package com.eaccount.controller.action;

import com.eaccount.domain.Company_profile;
import com.eaccount.domain.Product;
import com.eaccount.domain.User_profile;
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
        request.getSession().setAttribute("company_id_seller", request.getParameter("company_id_seller"));
        request.setAttribute("productList", list);

        List<Company_profile> company_profiles = new ArrayList<>();
        company_profiles = getProfileService.GetAllCompany();
        request.setAttribute("allcompany", company_profiles);

        List<User_profile> user_profiles = new ArrayList<>();
        user_profiles = getProfileService.GetUserByCompanyId(request.getParameter("company_id_seller"));
        request.setAttribute("sellerList", user_profiles);


        return "placeOrder";
    }
}
