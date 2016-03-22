package com.eaccount.controller.action;

import com.eaccount.domain.Company_profile;
import com.eaccount.domain.Message_list;
import com.eaccount.domain.Pay;
import com.eaccount.domain.User_profile;
import com.eaccount.service.*;
import com.eaccount.util.GetNowTime;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by spzn on 16-3-20.
 */
public class PayAction extends SuperAction{
    public String AddPayInfo() {
        String message_receiver = request.getParameter("message_receiver");
        String message_sender = request.getParameter("message_sender");
        String amount_of_money = request.getParameter("amount_of_money");
        IAddPayInfoService addPayInfoService = new AddPayInfoService();

        IGetProfileService getProfileService = new GetProfileService();
        List<User_profile> list = new ArrayList<>();
        list = getProfileService.GetUserInfoByUserId(message_sender);

        String company_id = getProfileService.GetCompanyIdByUserId(message_sender);
        String company_name = getProfileService.GetCompanyInfoByCompanyId(company_id).get(0).getCompany_name();

        //插入账单信息
        addPayInfoService.AddPayInfo(message_receiver, message_sender, amount_of_money, null);

        Message_list message_list = new Message_list();
        message_list.setMessage_sender(company_id);
        message_list.setMessage_date(new GetNowTime().GetTime(1));
        message_list.setMessage_type("8");
        message_list.setMessage_remark("money");
        message_list.setMessage_title(company_name + "支付" + amount_of_money + "元");
        ISendMessageService sendMessageService = new SendMessageService();

        //发送消息给该公司管理员
        List<Company_profile> listC = new ArrayList<>();
        listC = getProfileService.GetCompanyInfoByCompanyId(message_receiver);
        message_list.setMessage_receiver(listC.get(0).getManager_id());

        sendMessageService.SendMessage(message_list);

        return null;
    }

    public String GetPayInfoByCompanyId() throws IOException {
        String company_id = request.getParameter("company_id");
        IGetPayInfoService getPayInfoService = new GetPayInfoService();
        IGetProfileService getProfileService = new GetProfileService();
        List<Pay> list = new ArrayList<>();
        List<Company_profile> listC = new ArrayList<>();
        list = getPayInfoService.GetPayInfoByCompanyId(company_id);

        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = null;

        int len = 0;
        if (list.size() != 0) {
            len = list.size();
        }
        for (int i = 0; i < len; i++) {
            jsonObject = new JSONObject();
            String c_id = getProfileService.GetCompanyIdByUserId(list.get(i).getMessage_sender());
            listC = getProfileService.GetCompanyInfoByCompanyId(c_id);
            jsonObject.put("company_logo", listC.get(0).getCompany_logo());
            jsonObject.put("company_name", listC.get(0).getCompany_name());
            jsonObject.put("Id", list.get(i).getId());
            jsonObject.put("amount_of_money", list.get(i).getAmount_of_money());
            jsonObject.put("message_receiver", list.get(i).getMessage_receiver());
            jsonObject.put("message_sender", list.get(i).getMessage_sender());
            jsonObject.put("pay_state", list.get(i).getPay_state());
            jsonObject.put("pay_time", list.get(i).getPay_time());
            jsonObject.put("pay_picture", list.get(i).getPay_picture());
            jsonArray.add(jsonObject);
        }

        byte[] jsonBytes = jsonArray.toString().getBytes("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setContentLength(jsonBytes.length);
        response.getOutputStream().write(jsonBytes);
        response.getOutputStream().flush();
        response.getOutputStream().close();

        return null;
    }
}
