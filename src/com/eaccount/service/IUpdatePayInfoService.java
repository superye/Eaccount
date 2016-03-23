package com.eaccount.service;

/**
 * Created by spzn on 16-3-23.
 */
public interface IUpdatePayInfoService {
    public boolean UpdatePayState(String pay_id);
    public boolean UpdateAmountOfMoney(String pay_id, String amount_of_money);
}
