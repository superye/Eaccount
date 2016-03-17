package com.eaccount.controller.action;

import com.eaccount.domain.User_profile;
import com.eaccount.service.*;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yehao on 16/3/6.
 */
public class LoginAction extends SuperAction implements ModelDriven<User_profile>{
    User_profile user_profile = new User_profile();

    public String Login() {
        IGetProfileService getProfileService = new GetProfileService();
        IGetOrderService getOrderService = new GetOrderService();
        IGetMessageService getMessageService = new GetMessageService();
        JSONObject jsonObject = new JSONObject();
        String phone_number = user_profile.getUser_phone_number();
        String id = getProfileService.GetUserIdByPhone(phone_number);

        System.out.println(id);
        List<User_profile> user_profiles = new ArrayList<>();
        user_profiles = getProfileService.CheckLogin(user_profile.getUser_phone_number(), user_profile.getUser_password());
        int CountOverdueOrder = getOrderService.CountOverdueOrder(id);
        int CountUnreadMessage = getMessageService.CountUnreadMessage(id);
        int CountNoSendOrder = getOrderService.CountNotSendOrReceivingOrder(id, "1");
        int CountNoReceiving = getOrderService.CountNotSendOrReceivingOrder(id, "2");
        if (user_profiles.size()>0)
        {
            jsonObject.put("loginState", "1");
            jsonObject.put("id", user_profiles.get(0).getId());
            jsonObject.put("user_name", user_profiles.get(0).getUser_name());
            jsonObject.put("user_photo", user_profiles.get(0).getUser_photo());
            jsonObject.put("permission_delivery", user_profiles.get(0).getPermission_delivery());
            jsonObject.put("permission_receiving", user_profiles.get(0).getDesignate_receiving());
            jsonObject.put("permission_reconciliation", user_profiles.get(0).getPermission_reconciliation());
            jsonObject.put("permission_settlement", user_profiles.get(0).getPermission_settlement());
            jsonObject.put("designate_delivery", user_profiles.get(0).getDesignate_delivery());
            jsonObject.put("designate_receiving", user_profiles.get(0).getDesignate_receiving());
            jsonObject.put("permission_payment_day", user_profiles.get(0).getPermission_payment_day());
            jsonObject.put("permission_reject", user_profiles.get(0).getPermission_reject());
            jsonObject.put("permission_bill", user_profiles.get(0).getPermission_bill());
            jsonObject.put("CountOverdueOrder", CountOverdueOrder);
            jsonObject.put("CountUnreadMessage", CountUnreadMessage);
            jsonObject.put("CountNoSendOrder", CountNoSendOrder);
            jsonObject.put("CountNoReceivingOrder", CountNoReceiving);

        } else {
            jsonObject.put("loginState", "0");
        }
        try {
            byte[] jsonBytes = jsonObject.toString().getBytes("utf-8");
            response.setContentType("text/html;charset=utf-8");
            response.setContentLength(jsonBytes.length);
            response.getOutputStream().write(jsonBytes);
            response.getOutputStream().flush();
            response.getOutputStream().close();
        }catch (Exception e){}
        return SUCCESS;
    }


    @Override
    public User_profile getModel() {
        return user_profile;
    }
}
