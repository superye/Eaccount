package com.eaccount.service;

/**
 * Created by spzn on 16-3-20.
 */
public interface IAddPayInfoService {
    public boolean AddPayInfo(String message_receiver, String message_sender, String amount_of_money, String pay_picture);

}
