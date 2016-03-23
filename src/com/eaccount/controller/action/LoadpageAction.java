package com.eaccount.controller.action;

import com.eaccount.domain.Company_profile;
import com.eaccount.domain.Product;
import com.eaccount.domain.User_profile;
import com.eaccount.service.GetProfileService;
import com.eaccount.service.IGetProfileService;
import com.eaccount.util.GetNo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yehao on 16/3/16.
 */
public class LoadpageAction extends SuperAction{
    public String LoadPlaceorderPage() {
        List<Product> list = new ArrayList<>();
        IGetProfileService getProfileService = new GetProfileService();
        String company_id_seller = null;
        if (session.getAttribute("company_id_seller") == null) {
            company_id_seller = request.getParameter("company_id_seller");
            request.getSession().setAttribute("company_id_seller", request.getParameter("company_id_seller"));
        }
        else {
            company_id_seller = session.getAttribute("company_id_seller").toString();
        }
        list = getProfileService.GetCompanyProductById(company_id_seller);
        request.setAttribute("productList", list);

        List<Company_profile> company_profiles = new ArrayList<>();
        company_profiles = getProfileService.GetAllCompany();
        request.setAttribute("allcompany", company_profiles);

        List<User_profile> user_profiles = new ArrayList<>();
        user_profiles = getProfileService.GetUserByCompanyId(company_id_seller, "1");
        request.setAttribute("sellerList", user_profiles);

        request.setAttribute("NewestOrderId", new GetNo().GetOrderId());

        return "placeOrder";
    }

    public String LoadGoodsPage() {
        String id = session.getAttribute("company_id_seller").toString();
        List<Product> list = new ArrayList<>();
        IGetProfileService getProfileService = new GetProfileService();
        list = getProfileService.GetCompanyProductById(id);
        request.setAttribute("productList", list);
        return "goods";
    }
}
