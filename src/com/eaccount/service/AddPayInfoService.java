package com.eaccount.service;

import com.eaccount.dao.IPayDAO;
import com.eaccount.dao.PayDAO;
import com.eaccount.domain.Pay;
import com.eaccount.util.GetNowTime;

/**
 * Created by spzn on 16-3-20.
 */
public class AddPayInfoService implements IAddPayInfoService{
    @Override
    public boolean AddPayInfo(String message_receiver, String message_sender, String amount_of_money, String pay_picture) {
        Pay pay = new Pay();
        pay.setMessage_receiver(message_receiver);
        pay.setMessage_sender(message_sender);
        pay.setAmount_of_money(amount_of_money);
        pay.setPay_time(new GetNowTime().GetTime(1));
        pay.setPay_picture(pay_picture);

        IPayDAO payDAO = new PayDAO();
        return payDAO.AddPayInfo(pay);
    }


}
