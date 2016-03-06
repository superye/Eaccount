package com.eaccount.controller.action;

import com.eaccount.domain.User_profile;
import com.eaccount.service.GetProfileService;
import com.eaccount.service.IGetProfileService;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSONObject;

/**
 * Created by yehao on 16/3/6.
 */
public class LoginAction extends SuperAction implements ModelDriven<User_profile>{
    User_profile user_profile = new User_profile();

    public String Login() {
        IGetProfileService getProfileService = new GetProfileService();
        JSONObject jsonObject = new JSONObject();
        System.out.println(user_profile.getUser_phone_number());
        if(getProfileService.CheckLogin(user_profile.getUser_phone_number(), user_profile.getUser_password())){
            jsonObject.put("loginState", "1");
        } else {
            jsonObject.put("loginState", "0");
        }
        try {
            response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
        }catch (Exception e){}
        return null;
    }
    @Override
    public User_profile getModel() {
        return user_profile;
    }
}
