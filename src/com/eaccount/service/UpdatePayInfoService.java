package com.eaccount.service;

import com.eaccount.dao.IPayDAO;
import com.eaccount.dao.PayDAO;
import com.eaccount.domain.Pay;

/**
 * Created by spzn on 16-3-23.
 */
public class UpdatePayInfoService implements IUpdatePayInfoService{
    @Override
    public boolean UpdatePayState(String pay_id) {
        IPayDAO payDAO = new PayDAO();
        return payDAO.UpdatePayState(pay_id);
    }

    @Override
    public boolean UpdateAmountOfMoney(String pay_id, String amount_of_money) {
        Pay pay = new Pay();
        pay.setId(pay_id);
        pay.setAmount_of_money(amount_of_money);
        IPayDAO payDAO = new PayDAO();
        return payDAO.UpdateAmountOfMoney(pay);
    }
}
