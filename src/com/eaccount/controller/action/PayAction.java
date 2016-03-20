package com.eaccount.controller.action;

import com.eaccount.domain.Message_list;
import com.eaccount.domain.User_profile;
import com.eaccount.service.*;
import com.eaccount.util.GetNowTime;

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
        addPayInfoService.AddPayInfo(message_receiver, message_sender, amount_of_money, null);

        IGetProfileService getProfileService = new GetProfileService();
        List<User_profile> list = new ArrayList<>();
        list = getProfileService.GetUserInfoByUserId(message_sender);

        Message_list message_list = new Message_list();
        message_list.setMessage_sender(message_sender);
        message_list.setMessage_receiver(message_receiver);
        message_list.setMessage_date(new GetNowTime().GetTime(1));
        message_list.setMessage_type("8");
        message_list.setMessage_remark("money");
        message_list.setMessage_title(list.get(0).getUser_name() + "向您支付" + amount_of_money + "元");
        ISendMessageService sendMessageService = new SendMessageService();
        sendMessageService.SendMessage(message_list);
        return null;
    }
}
